import java.util.*;

public class MinimumKnightMovies {
    public static void main(String args[]) {
        System.out.println(minKnightMoves(5, 5));
    }

    public static int minKnightMoves(int x, int y) {
        int result =0;
        int matrix[][] = new int[][] {{2, 1}, {1, 2}, {-2, 1}, {1, -2}, {-1, 2}, {2, -1}, {-2, -1}, {-1, -2}};

        Set<String> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();

                if (node[0] == x && node[1] == y) return result;

                for (int j = 0; j < 8; j++) {
                    int nx = node[0] + matrix[j][0];
                    int ny = node[1] + matrix[j][1];
                    if (Math.abs( (nx -x) + (ny-y)) < 3 + Math.abs((matrix[j][0] - x) + (matrix[j][1] -y))
                        && !set.contains(nx + " " + ny)) {
                        set.add(nx + " " + ny);
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            result ++;
        }
        return result;
    }
}
