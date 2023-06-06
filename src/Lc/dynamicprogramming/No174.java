package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/dungeon-game/">地下城游戏</a>
 **/
public class No174 {

    /**
     * @see <a href="https://labuladong.gitee.io/algo/di-er-zhan-a01c6/yong-dong--63ceb/dong-tai-g-f43a3/">思路</a>
     **/

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] memo = new int[m][n];
        memo[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? 1 - dungeon[m - 1][n - 1] : 1;
        // 最右一列赋值
        for (int i = m - 2; i >= 0; i--) {
            memo[i][n - 1] = memo[i + 1][n - 1] > dungeon[i][n - 1] ?
                    memo[i + 1][n - 1] - dungeon[i][n - 1] : 1;
        }
        // 最下一行赋值
        for (int j = n - 2; j >= 0; j--) {
            memo[m - 1][j] = memo[m - 1][j + 1] > dungeon[m - 1][j] ?
                    memo[m - 1][j + 1] - dungeon[m - 1][j] : 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int tmp = memo[i + 1][j] < memo[i][j + 1] ? memo[i + 1][j] : memo[i][j + 1];
                memo[i][j] = tmp > dungeon[i][j] ? tmp - dungeon[i][j] : 1;
            }
        }
        return memo[0][0];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}, 7},
                {new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, 5}}, 6},
                {new int[][]{{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}}, 3},
                {new int[][]{{0, 5}, {-2, -3}}, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] grid, int expected) {
        int res = calculateMinimumHP(grid);
        Assert.assertEquals(res, expected);
    }

}
