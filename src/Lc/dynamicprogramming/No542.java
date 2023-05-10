package Lc.dynamicprogramming;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/01-matrix/?show=1">No542 01矩阵</a>
 **/
public class No542 {

    int[][] memo;

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int count = m * n;
        // 初始化，将所有0置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0 && memo[i][j] == -1) {
                    memo[i][j] = 0;
                    count--;
                }
            }
        }
        int center = 0;
        while (count > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (memo[i][j] == center) {
                        if (i + 1 < m) {
                            // 未赋值过
                            if (memo[i + 1][j] < 0) {
                                memo[i + 1][j] = center + 1;
                                count--;
                            } else {
                                // 已赋值时，需要判断大小是否合适
                                memo[i][j] = memo[i + 1][j] + 1 < memo[i][j] ? memo[i + 1][j] + 1 : memo[i][j];
                            }
                        }
                        if (i - 1 >= 0) {
                            if (memo[i - 1][j] < 0) {
                                memo[i - 1][j] = center + 1;
                                count--;
                            } else {
                                memo[i][j] = memo[i - 1][j] + 1 < memo[i][j] ? memo[i - 1][j] + 1 : memo[i][j];
                            }
                        }
                        if (j + 1 < n) {
                            if (memo[i][j + 1] < 0) {
                                memo[i][j + 1] = center + 1;
                                count--;
                            } else {
                                memo[i][j] = memo[i][j + 1] + 1 < memo[i][j] ? memo[i][j + 1] + 1 : memo[i][j];
                            }
                        }
                        if (j - 1 >= 0) {
                            if (memo[i][j - 1] < 0) {
                                memo[i][j - 1] = center + 1;
                                count--;
                            } else {
                                memo[i][j] = memo[i][j - 1] + 1 < memo[i][j] ? memo[i][j - 1] + 1 : memo[i][j];
                            }
                        }
                    }
                }
            }
            center++;
        }
        return memo;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}},
                {new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 1}, {1, 0, 1, 1}}, new int[][]{{3, 2, 3, 4}, {2, 1, 2, 3}, {1, 0, 1, 2}, {1, 0, 1, 2}}},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] n, int[][] expected) {
        int[][] res = updateMatrix(n);
        for (int[] row : res) {
            ArrayList<Integer> x = new ArrayList<>();
            for (int i = 0; i < row.length; i++) {
                x.add(row[i]);
            }
            System.out.println(x);
        }
    }


}
