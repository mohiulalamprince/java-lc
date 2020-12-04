public class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix.length > 0 ? matrix[0].length : 0;
        int[][] dp = new int[row + 1][col + 1];

        int maxSquare = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i - 1][j], matrix[i][j-1]));
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
}
