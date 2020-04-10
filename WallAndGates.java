public class WallAndGates {
    static int[][] matrix = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    static int INF = 2147483647;

    public static void main(String args[]) {
        int[][] rooms = new int[][]{{INF, -1, 0, INF}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
        wallsAndGates(rooms);
    }

    public static void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0)
                    dfs(i, j, rooms, 0);
            }
        }
    }

    public static void dfs(int i, int j, int[][] rooms, int cost) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;

        for (int k = 0; k < 4; k++) {
            int nr = i + matrix[k][0];
            int nc = j + matrix[k][1];

            if (nr < 0 || nr >= rooms.length || nc < 0 || nc >= rooms[0].length) continue;

            if (rooms[nr][nc] > cost + 1 && rooms[nr][nc] != 0 && rooms[nr][nc] != -1) {
                rooms[nr][nc] = cost + 1;
                dfs(nr, nc, rooms, cost + 1);
            }
        }
    }
}
