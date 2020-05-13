public class NumberofIslands {
    static boolean visit[][] = null;
    public  boolean found = false;
    public  int[][] matrix = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public  void main(String args[]) {

    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        int result = 0;
        visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visit[i][j] = false;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j  = 0; j < grid[0].length; j++) {
                if (visit[i][j] == false && grid[i][j] == '1') {
                    visit[i][j] = true;
                    found = true;
                    dfs(i, j, grid);
                    if (found) result++;
                }
            }
        }
        return result;
    }

    public void dfs(int x, int y, char[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nr = matrix[i][0] + x;
            int nc = matrix[i][1] + y;

            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;

            if (visit[nr][nc] == false && grid[nr][nc] == '1') {
                visit[nr][nc] = true;
                dfs(nr, nc, grid);
            }
        }
    }
}
