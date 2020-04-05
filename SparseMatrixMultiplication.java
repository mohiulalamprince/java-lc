public class SparseMatrixMultiplication {
    public static int[][] multiply(int[][] A, int[][] B) {
        int ab[][] = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {

                for (int k = 0; k < B[0].length; k++) {
                    ab[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return ab;
    }

    public static void main(String args[]) {
        int res[][] = multiply(new int[][] {{1, -5}}, new int[][]{{12}, {-1}});
    }
}
