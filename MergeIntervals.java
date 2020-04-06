import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static void main(String args[]) {
        int[][] res = merge(new int[][]{{0, 0},{5, 5}, {5, 5}, {5, 6}});
        for (int i =0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return (x == node.x &&
                    y == node.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};

        ArrayList<Node> points = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            points.add(new Node(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(points, Comparator.comparing(Node::getX).thenComparing(Node::getY));
        List<Node> pointsList = points.stream().distinct().collect(Collectors.toList());

        intervals = new int [pointsList.size()][2];
        for (int i = 0; i < pointsList.size(); i++) {
            intervals[i][0] = pointsList.get(i).getX();
            intervals[i][1] = pointsList.get(i).getY();
        }

        ArrayList<Integer> result = new ArrayList<>();
        int counter = 0;

        int start = 0;
        int end = 0;
        start = intervals[0][0];
        end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (isOverlapped(start, end, intervals[i][0], intervals[i][1])) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                result.add(start);
                result.add(end);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(start);
        result.add(end);

        int[][] res = new int[result.size()/2][2];
        for (int i = 0; i < result.size(); i += 2) {
            res[counter][0] = result.get(i);
            res[counter++][1] = result.get(i + 1);
        }
        return res;
    }

    public static boolean isOverlapped(int x1, int y1, int x2, int y2) {
        if (x1 < y2 && y1 >= x2) return true;
        else return false;
    }
}
