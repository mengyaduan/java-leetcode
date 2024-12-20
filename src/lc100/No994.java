package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No994 {

    int[][] used;

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean needAnotherRound = true;
        int result = 0;
        used = new int[m][n];
        int freshLeft = 0;
        int roundNum = 0;
        while (needAnotherRound) {
            freshLeft = 0;
            needAnotherRound = false;
            result += 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        freshLeft++;
                    }
                    if (grid[i][j] == 2 && used[i][j] == roundNum) {
                        // 有腐烂橘子，向四周扩散，先标记处理
//                        used[i][j] = roundNum;
                        // 感染上下左右
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            needAnotherRound = true;
                            grid[i - 1][j] = 2;
                            used[i - 1][j] = roundNum + 1;
                        }
                        if (i + 1 < m && grid[i + 1][j] == 1) {
                            needAnotherRound = true;
                            grid[i + 1][j] = 2;
                            used[i + 1][j] = roundNum + 1;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            needAnotherRound = true;
                            grid[i][j - 1] = 2;
                            used[i][j - 1] = roundNum + 1;
                        }
                        if (j + 1 < n && grid[i][j + 1] == 1) {
                            needAnotherRound = true;
                            grid[i][j + 1] = 2;
                            used[i][j + 1] = roundNum + 1;
                        }
                    }
                }
            }
            roundNum++;
        }
        return freshLeft > 0 ? -1 : result - 1;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        Assert.assertEquals(orangesRotting(grid), 4);
    }
}
