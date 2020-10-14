import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MeetingRoomsII {

    static List<List<int[]>> pairs = new ArrayList<>();

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<Node> intervalsList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++)
            intervalsList.add(new Node(intervals[i][0], intervals[i][1]));

        List<Node> sortedList = intervalsList.stream()
                .sorted(Comparator.comparingInt(Node::getA))
                .collect(Collectors.toList());

        pq.add(sortedList.get(0).getB());

        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i).getA() >= pq.peek())
                pq.poll();
            pq.add(sortedList.get(i).getB());
        }
        return pq.size();
    }

    public static void main(String args[]) {
        Consumer<Integer> out = System.out::println;
        int[][] test = new int[][] {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        //out.accept(minMeetingRooms(test));

        out.accept(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }

    private static class Node {
        int a; int b;
        public Node() {
        }

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
