package LC100Again;


import netscape.security.UserTarget;

public class Lc020 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        while (n > 1) {
            for (int j = start; j < start + n - 1; j++) {
                swapFour(matrix, start, j);
            }
            start++;
            n -= 2;
        }
    }

    /**
     * x,y          y,n-1-x
     * n-1-y,x      n-1-x, n-1-y
     */
    private void swapFour(int[][] matrix, int i, int j) {
        int base = matrix.length;
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[base - 1 - j][i];
        matrix[base - 1 - j][i] = matrix[base - 1 - i][base - 1 - j];
        matrix[base - 1 - i][base - 1 - j] = matrix[j][base - 1 - i];
        matrix[j][base - 1 - i] = tmp;
    }

}
