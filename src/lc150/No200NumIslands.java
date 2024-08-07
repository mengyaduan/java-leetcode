package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No200NumIslands {

    int[][] helper;

    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        helper = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper[i][j] == 0 && grid[i][j] == '1') {
                    // 如果未标记且是岛屿时，进行DFS
                    ans++;
                    helper[i][j] = 1;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int m, int n, int i, int j) {
//        if (i < 0 || j < 0 || i >= m || j >= n) {
//            return;
//        }
        // 遍历上下左右，如果标记过或者是0，跳过；如果是1，标记&加入遍历的行列
        int[] xs = new int[]{i - 1, i + 1, i, i};
        int[] ys = new int[]{j, j, j - 1, j + 1};
        for (int k = 0; k < 4; k++) {
            int x = xs[k];
            int y = ys[k];
            if (validXY(m, n, x, y) && helper[x][y] == 0 && grid[x][y] == '1') {
                helper[x][y] = 1;
                dfs(grid, m, n, x, y);
            }
        }
    }

    /**
     * 校验坐标是否越界
     */
    public boolean validXY(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
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
    }


    @Test(description = "")
    public void test2() throws Exception {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(numIslands(grid), 3);
    }
}
