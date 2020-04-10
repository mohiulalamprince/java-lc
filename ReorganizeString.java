import java.util.*;

public class ReorganizeString {

    static class Node {
        Character c;
        int frequency;

        public Node(Character c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }

        public Character getC() {
            return c;
        }

        public void setC(Character c) {
            this.c = c;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }
    public static void main(String args[]) {
        System.out.println(reorganizeString("vvvlo"));
    }

    public static String reorganizeString(String S) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getFrequency).reversed());

        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            Node node = new Node((Character)entry.getKey(), (int)entry.getValue());
            pq.add(node);
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (sb.length() == 0 || node.c != sb.charAt(sb.length() - 1)) {
                sb.append(node.c);
                if (node.frequency > 1)
                    pq.add(new Node(node.c, node.frequency -1));
            } else {
                Node secondNode = pq.poll();
                if (secondNode == null) {
                    return "";
                }

                if (secondNode.c != sb.charAt(sb.length() -1)) {
                    sb.append(secondNode.c);
                    if (secondNode.frequency > 1)
                        pq.add(new Node(node.c, node.frequency -1));
                }
                pq.add(node);
            }
        }
        return sb.toString();
    }
}
