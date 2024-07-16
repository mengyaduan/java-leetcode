package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No73SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] colEffected = new int[n];

        for (int i = 0; i < m; i++) {
            boolean rowEffected = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowEffected = true;
                    colEffected[j] = 1;
                }
            }
            if (rowEffected) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colEffected[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
