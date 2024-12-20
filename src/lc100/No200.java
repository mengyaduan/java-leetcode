package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No200 {

    int[][] used;
    int result;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        result = 0;
        used = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && used[i][j] == 0) {
                    result += 1;
                    expand(grid, i, j);
                }
            }
        }
        return result;
    }

    private void expand(char[][] grid, int i, int j) {
        // 优先标记当前节点为已探索
        used[i][j] = 1;
        // 向上
        int x = i - 1, y = j;
        if (x >= 0 && grid[x][y] == '1' && used[x][y] == 0) {
            expand(grid, x, y);
        }
        // 向下
        x = i + 1;
        if (x < grid.length && grid[x][y] == '1' && used[x][y] == 0) {
            expand(grid, x, y);
        }
        // 向左
        x = i;
        y = j - 1;
        if (y >= 0 && grid[x][y] == '1' && used[x][y] == 0) {
            expand(grid, x, y);
        }
        // 向右
        y = j + 1;
        if (y < grid[0].length && grid[x][y] == '1' && used[x][y] == 0) {
            expand(grid, x, y);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals(numIslands(grid), 1);
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(numIslands(grid2), 3);


    }
}
