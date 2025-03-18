package Lc119;

/**
 * LCR013
 */
public class NumMatrix {
    int[][] matrix;
    int[][] preRowSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.matrix = new int[m][n];
        this.preRowSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (j == 0) {
                    this.preRowSum[i][j] = matrix[i][j];
                } else {
                    this.preRowSum[i][j] = matrix[i][j] + this.preRowSum[i][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += this.preRowSum[i][col2] - (col1 < 1 ? 0 : this.preRowSum[i][col1 - 1]);
        }
        return result;
    }
}
