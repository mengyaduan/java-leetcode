package LcSpring100;

import org.testng.annotations.Test;

import java.util.Arrays;

public class No329LongestIncreasingPath {

    int[][] helper;

    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        int m = matrix.length, n = matrix[0].length;
        // 使用另一个矩阵，记录每个节点往下探的时候，能探到的最长路径
        helper = new int[m][n];
        for (int[] row : helper) {
            Arrays.fill(row, -1);
        }
        // 通过dfs更新
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper[i][j] == -1) {
                    dfs(matrix, m, n, i, j);
                }
            }
        }
        // 计算最大值
        for (int[] row : helper) {
            for (int item : row) {
                result = Math.max(result, item);
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int m, int n, int i, int j) {
        if (helper[i][j] != -1) {
            return helper[i][j];
        }
        int up = i - 1 < 0 ? Integer.MAX_VALUE : matrix[i - 1][j];
        int down = i + 1 == m ? Integer.MAX_VALUE : matrix[i + 1][j];
        int left = j - 1 < 0 ? Integer.MAX_VALUE : matrix[i][j - 1];
        int right = j + 1 == n ? Integer.MAX_VALUE : matrix[i][j + 1];
        // 如果当前值已经比上下左右都小，那么其长度为1
        int item = matrix[i][j];
        if (item <= up && item <= down && item <= left && item <= right) {
            helper[i][j] = 1;
            return 1;
        }
        // 否则计算所有比item小的方向的结果，然后更新helper
        if (item > up) {
            helper[i][j] = Math.max(dfs(matrix, m, n, i - 1, j) + 1, helper[i][j]);
        }
        if (item > down) {
            helper[i][j] = Math.max(dfs(matrix, m, n, i + 1, j) + 1, helper[i][j]);
        }
        if (item > left) {
            helper[i][j] = Math.max(dfs(matrix, m, n, i, j - 1) + 1, helper[i][j]);
        }
        if (item > right) {
            helper[i][j] = Math.max(dfs(matrix, m, n, i, j + 1) + 1, helper[i][j]);
        }
        return helper[i][j];
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        int x = longestIncreasingPath(matrix);
        System.out.println(x);


    }

}
