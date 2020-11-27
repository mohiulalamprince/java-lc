import java.util.*;

public class NumberOfDistinctIslands {
    static ArrayList<Integer> signature = new ArrayList<>();
    static int[][] visit;

    public static void main(String args[]) {
        //int[][] input = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int[][] input = new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}, {1, 1, 1}, {0, 1, 0}};
        int result = numDistinctIslands(input);
        System.out.println(result);
    }

    public static int numDistinctIslands(int[][] grid) {
        visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                visit[i][j] = 0;

        Set<ArrayList<Integer>> signatures = new HashSet<>();
        for (int r = 0; r < grid.length; r++) {
           for (int c = 0; c < grid[0].length; c++) {
               signature = new ArrayList<>();

               if (grid[r][c] == 1 && visit[r][c] == 0) {
                   visit[r][c] = 1;
                   find(grid, r, c, 0);
                   if (signature.size() > 0)
                       signatures.add(signature);
               }
           }
        }
        return signatures.size();
    }

    static int[][] matrix = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void find(int[][] grid, int r, int c, int d) {
        signature.add(d);
        for (int i = 0; i < 4; i++) {
            int nr = r + matrix[i][0];
            int nc = c + matrix[i][1];

            if (nc < 0 || nr < 0 || nc >= grid[0].length || grid.length <= nr) continue;

            if (grid[nr][nc] == 1 && visit[nr][nc] == 0) {
                visit[nr][nc] = 1;
                find(grid, nr, nc, i + 1);
                signature.add(0);
            }
        }
    }
}
