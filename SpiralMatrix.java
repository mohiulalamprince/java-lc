import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String args[]) {
        int[][] result = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> output = spiralOrder(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int n1, n2;
        int m1, m2;
        int i = 0, j = 0;
        String dir = "right";

        n1 = m1 = 0;
        m2 = matrix.length - 1;
        n2 = matrix[0].length - 1;
        result.add(matrix[0][0]);
        while (result.size() < matrix.length * matrix[0].length) {
            if (dir.equals("right")) {
                if (j < n2) {
                    j++;
                }
                else {
                    dir = "down";
                    i++;
                    m1++;
                }
            }
            else if (dir.equals("down")) {
                if (i < m2) {
                    i++;
                } else {
                    dir = "left";
                    j--;
                    n2--;
                }
            }
            else if (dir.equals("left")) {
                if (j > n1) {
                    j--;
                } else {
                    dir = "up";
                    i--;
                    m2--;
                }
            }
            else if (dir.equals("up")) {
                if (i > m1) {
                    i--;
                } else {
                    dir = "right";
                    j++;
                    n1++;
                }
            }
            result.add(matrix[i][j]);
        }

        return result;
    }
}
