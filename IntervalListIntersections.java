import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String args[]) {
        //int result[][] = intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        int result[][] = intervalIntersection(new int[][]{{5, 10}}, new int[][]{{3, 10}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);

            if (lo <= hi)
                result.add(new int[]{lo, hi});
            if (A[i][1] < B[j][1]) i++;
            else j++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
