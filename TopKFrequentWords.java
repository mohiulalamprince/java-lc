import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequentWords {
    public static void main(String args[]) {

    }

    static class Node {
        String s;
        int f;

        public Node(String s, int f) {
            this.s = s;
            this.f = f;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Node> result = map.entrySet().stream().map(x -> new Node((String)x.getKey(), (int)x.getValue())).collect(Collectors.toList());

        Collections.sort(result, Comparator.comparing(Node::getF).reversed().thenComparing(Node::getS));
        return result.stream().map(node -> node.s).limit(k).collect(Collectors.toList());
    }
}
