package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/maximal-square/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No221MaximalSquare {

    /**
     * 从最下行和最右列，往左上角挤，如果m[i][j]=0，则结果是0，否则是右下相邻元素的最小值+1
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        int[][] helper = new int[m][n];
        // 初始化最下行和最右列
        for (int i = 0; i < m; i++) {
            helper[i][n - 1] = matrix[i][n - 1] == '1' ? 1 : 0;
            result = Math.max(helper[i][n - 1], result);
        }
        for (int j = 0; j < n; j++) {
            helper[m - 1][j] = matrix[m - 1][j] == '1' ? 1 : 0;
            result = Math.max(helper[m - 1][j], result);
        }
        // 从右下往左上
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                helper[i][j] = matrix[i][j] == '0' ? 0 : (minValueAround(helper, i, j) + 1);
                result = Math.max(result, helper[i][j]);
            }
        }
        return result * result;
    }

    private int minValueAround(int[][] helper, int i, int j) {
        // 右 vs 下
        int result = Math.min(helper[i][j + 1], helper[i + 1][j]);
        // result vs 右下
        return Math.min(result, helper[i + 1][j + 1]);
    }


    @Test(description = "")
    public void test() throws Exception {
        char[][] array = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(array));

    }

}
