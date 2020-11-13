import java.util.*;
import java.util.stream.Collectors;

class FileSystem {

    class Node {
        boolean isDir = true;
        String data = "";
        String name = "";
        List<Node> dirOrFileList;

        Node(boolean isDir, String name, String data) {
            this.isDir = isDir;
            this.data = data;
            this.name = name;
            this.dirOrFileList = new ArrayList<>();
        }
    }

    Node filesystem;

    public FileSystem() {
        filesystem = new Node(true, "/", null);
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        Node current = filesystem;
        String paths[] = path.split("/");

        int inc = 1;
        while (inc < paths.length) {
            for (Node node : current.dirOrFileList) {
                if (inc == paths.length-1 && node.isDir && node.name.equals(paths[inc])) {
                    for (Node n : node.dirOrFileList) {
                        result.add(n.name);
                    }
                    return result
                            .stream()
                            .sorted(Comparator.comparing(String::toString))
                            .collect(Collectors.toList());
                } else if (inc == paths.length - 1 && node.isDir == false && node.name.equals(paths[inc])) {
                    return new ArrayList<>(Arrays.asList(node.name));
                }
                else if (node.name.equals(paths[inc])) {
                    current = node;
                    break;
                }
            }
            inc++;
        }
        return current.dirOrFileList
                .stream()
                .map(x -> x.name)
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());
    }

    public void mkdir(String path) {
        String[] paths = path.split("/");
        Node current = filesystem;

        int inc = 1;
        while (inc < paths.length) {
            boolean notFound = true;
            for (Node node : current.dirOrFileList) {
                if (node.name.equals(paths[inc])) {
                    current = node;
                    notFound = false;
                    break;
                }
            }
            if (notFound) {
                current.dirOrFileList.add(new Node(true, paths[inc], null));
                current = current.dirOrFileList.get(current.dirOrFileList.size()-1);
            }
            inc++;
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        Node current = filesystem;

        int inc = 1;
        while (inc < paths.length) {
            boolean notFound = true;
            for (Node node : current.dirOrFileList) {
                if (node.isDir == false && node.name.equals(paths[inc])) {
                    node.data = node.data + content;
                    notFound = false;
                    break;
                }
                if (node.isDir && node.name.equals(paths[inc])) {
                    current = node;
                    notFound = false;
                    break;
                }
            }
            if (notFound) {
                if (paths.length -1 == inc) {
                    current.dirOrFileList.add(new Node(false, paths[inc], content));
                } else {
                    current.dirOrFileList.add(new Node(true, paths[inc], null));
                    current = current.dirOrFileList.get(current.dirOrFileList.size() - 1);
                }
            }
            inc++;
        }
    }

    public String readContentFromFile(String filePath) {
        Node current = filesystem;

        int inc = 1;
        String[] paths = filePath.split("/");
        while (inc < paths.length) {

            for (Node node : current.dirOrFileList) {
                if (node.isDir && node.name.equals(paths[inc])) {
                    current = node;
                    break;
                } else if (node.isDir == false && node.name.equals(paths[inc])) {
                    return node.data;
                }
            }
            inc++;
        }
        return null;
    }
}


public class DesignInMemoryFileSystem {
    public static void main(String args[]) {
        FileSystem fs = new FileSystem();

        /*List<String> out1 = fs.ls("/");
        fs.mkdir("/b/a/c");
        List<String> out4 = fs.ls("/b/a/c");
        fs.mkdir("/b/a/d");
        List<String> out5 = fs.ls("/a/b");
        fs.addContentToFile("/a/b/c/d", "hello");
        List<String> out3 = fs.ls("/");
        String out2 = fs.readContentFromFile("/a/b/c/d");*/

        fs.mkdir("/goowmfn");
        List<String> out1 = fs.ls("/goowmfn");
        List<String> out2 = fs.ls("/");
        fs.mkdir("/z");
        List<String> out3 = fs.ls("/");
        List<String> out4 = fs.ls("/");
        fs.addContentToFile("/goowmfn/c", "shetopcy");
        List<String> out5 = fs.ls("/z");
        List<String> out6 = fs.ls("/goowmfn/c");
        List<String> out7 = fs.ls("/goowmfn");

    }
}
