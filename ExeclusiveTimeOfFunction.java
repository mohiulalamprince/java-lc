import java.util.*;

public class ExeclusiveTimeOfFunction {
    class Node {
        int value;
        int index;
        boolean isStart;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean isStart() {
            return isStart;
        }

        public void setStart(boolean start) {
            isStart = start;
        }
    }
    public  void main(String args[]) {
        System.out.println(exclusiveTime(2, new ArrayList(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
    }

    public  int[] exclusiveTime(int n, List<String> logs) {
        int result[] = new int[n];

        ArrayList<Node> table = new ArrayList<>();

        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] parts = log.split(":");
            if (parts[1].equals("start")) {
                Node node = new Node();
                node.value = Integer.parseInt(parts[0]);
                node.index = Integer.parseInt(parts[2]);
                node.isStart = true;
                table.add(node);
            } else {
                Node node = new Node();
                node.value = Integer.parseInt(parts[0]);
                node.index = Integer.parseInt(parts[2]);
                node.isStart = false;
                table.add(node);
            }
        }
        Collections.sort(table, Comparator.comparing(Node::getIndex));

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < table.size(); i++) {
            Node node = table.get(i);
            if (node.isStart) {
                stack.add(node);
            } else {
                Node startNode = stack.pop();
                Node endNode = node;

                int interval = endNode.index - startNode.index + 1;
                result[startNode.value] += interval;
                if (!stack.empty()) {
                    result[stack.peek().getValue()] -= interval;
                }
            }
        }

        return result;
    }
}
