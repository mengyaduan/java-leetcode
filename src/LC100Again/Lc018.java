package LC100Again;


public class Lc018 {

    public void setZeroes(int[][] matrix) {
        // 默认第一行第一列都不需要置零
        int row0 = 1, col0 = 1;
        // 用第一行标记需要置零的列，用第一列标记需要置零的行
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是第一行或者第一列，不更改数据，只处理标记
                if (i == 0 || j == 0) {
                    if (i == 0 && matrix[i][j] == 0) {
                        row0 = 0;
                    }
                    if (j == 0 && matrix[i][j] == 0) {
                        col0 = 0;
                    }
                }
                // 非首行首列，正常处理
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 将除了第一行第一列以外的其他，全部置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 根据col0和row0处理
        if (row0 == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
