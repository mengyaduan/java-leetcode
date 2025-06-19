package Lc119;

import org.testng.annotations.Test;

import java.util.Arrays;

public class LCR112 {

    public int longestIncreasingPath(int[][] matrix) {
        int result = 1;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = dfs(matrix, m, n, memo, i, j);
                result = Math.max(result, x);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int m, int n, int[][] memo, int i, int j) {
        // 已经计算过
        if (memo[i][j] >= 0) {
            return memo[i][j];
        }
        int res = 1;
        // 开始计算，找到上下左右最长的，当前+1
        int next = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            next = Math.max(next, dfs(matrix, m, n, memo, i - 1, j));
        }
        if (i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
            next = Math.max(next, dfs(matrix, m, n, memo, i + 1, j));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            next = Math.max(next, dfs(matrix, m, n, memo, i, j - 1));
        }
        if (j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
            next = Math.max(next, dfs(matrix, m, n, memo, i, j + 1));
        }
        memo[i][j] = res + next;
        return memo[i][j];
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] matrix = new int[][]{
                {3, 4, 5}, {3, 2, 6}, {2, 2, 1}
        };
        System.out.println(longestIncreasingPath(matrix));

    }
}
