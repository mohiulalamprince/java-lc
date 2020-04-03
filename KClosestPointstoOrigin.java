import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KClosestPointstoOrigin {
    static class Node {
        int point[];
        double dist;

        public Node(int[] point, double dist) {
            this.point = point;
            this.dist = dist;
        }

        public double getDist() {
            return dist;
        }

        public void setDist(double dist) {
            this.dist = dist;
        }
    }
    public static void main(String args[]) {
        int result[][] = kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        int result2[][] = kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        int x =0;
    }

    public static int[][] kClosest(int[][] points, int K) {
        List<Node> result = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < points.length; i++) {
            double res = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            result.add(new Node(points[i], res));
        }

        Collections.sort(result, Comparator.comparing(Node::getDist));

        int[][] output = new int[K][2];
        for (int i = 0; i < K; i++) {
            output[i] = result.get(i).point;
        }
        return output;
    }
}
