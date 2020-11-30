public class FriendCircle {
    static int visit[];
    static int counter = 0;

    public static void main(String args[]) {

    }

    public static int findCircleNum(int[][] M) {
        int result = 0;
        if (M.length == 0) return 0;

        visit = new int[M.length];
        for (int i = 0; i < M.length; i++) {
                visit[i] = 0;
        }

        for (int i = 0; i < M.length; i++) {
            counter = 0;
            if (visit[i] == 0) {
                visit[i] = 1;
                dfs(i, M);
                if (counter > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    static void dfs(int x, int[][] M) {
        for (int i = 0; i < M[x].length; i++) {
            if (visit[M[x][i]] == 0) {
                visit[M[x][i]] = 1;
                counter++;
                dfs(M[x][i], M);
            }
        }
    }
}
