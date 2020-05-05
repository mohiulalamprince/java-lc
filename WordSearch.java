public class WordSearch {
    static int[][] matrix = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean visit[][] = null;
    static boolean answer = false;
    public static void main(String args[]) {
        char[][] board = new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcb";
        boolean res = exist(board, word);
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board == null) return false;
        visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                answer = false;
                if (board[i][j] == word.charAt(0)) {
                    visit[i][j] = true;
                    dfs(i, j, board, word, 1);
                    visit[i][j] = false;
                }
                if (answer) return true;
            }
        }
        return false;
    }

    public static void dfs(int x, int y, char[][] board, String word, int index) {
        if (answer == true) return ;
        if (index == word.length()) {
            answer = true;
            return ;
        }
        if (index > word.length()) return;
        for (int i = 0; i < 4; i++) {
            int nx = matrix[i][0] + x;
            int ny = matrix[i][1] + y;
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[x].length) continue;

            if (visit[nx][ny] == false && board[nx][ny] == word.charAt(index)) {
                visit[nx][ny] = true;
                dfs(nx, ny, board, word, index + 1);
                visit[nx][ny] = false;
            }
        }
    }
}
