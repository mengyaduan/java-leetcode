package lc150;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No63UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] helper = new int[m][n];
        helper[0][0] = obstacleGrid[0][0] == 0 ? 1 : -1;
        for (int j = 1; j < n; j++) {
            helper[0][j] = obstacleGrid[0][j] == 1 ? -1 : helper[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            helper[i][0] = obstacleGrid[i][0] == 1 ? -1 : helper[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    helper[i][j] = 0;
                } else {
                    int left = helper[i - 1][j] > 0 ? helper[i - 1][j] : 0;
                    int up = helper[i][j - 1] > 0 ? helper[i][j - 1] : 0;
                    helper[i][j] = left + up;
                }
            }
        }
        return helper[m - 1][n - 1] > 0 ? helper[m - 1][n - 1] : 0;
    }

    @Test(description = "")
    public void test0() throws Exception {
        int[][] ob = new int[][]{
                {0, 1},
                {0, 0},
        };

        Assert.assertEquals(uniquePathsWithObstacles(ob), 1);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] ob = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        Assert.assertEquals(uniquePathsWithObstacles(ob), 2);
    }
}
