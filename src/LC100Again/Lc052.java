package LC100Again;


import org.testng.annotations.Test;

public class Lc052 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        boolean hasRotten = false;
        int result = 0;
        int rottenFlag = 2;
        while (true) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == rottenFlag) {
                        hasRotten = hasInfectAnyone(grid, i, j, rottenFlag) || hasRotten;
                    }
                }
            }
            // 如果本轮未触发任何腐烂
            if (!hasRotten) {
                break;
            }
            // 本轮已触发腐烂
            result++;
            rottenFlag++;
            hasRotten = false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }

    private boolean hasInfectAnyone(int[][] grid, int i, int j, int flag) {
        boolean hasInfect = false;
        // 已经处理过了，则直接删除该橘子
        grid[i][j] = 0;
        // 污染四周的橘子
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = flag + 1;
            hasInfect = true;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = flag + 1;
            hasInfect = true;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = flag + 1;
            hasInfect = true;
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = flag + 1;
            hasInfect = true;
        }
        return hasInfect;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 1},
                {0, 1, 2}
        };
        System.out.println(orangesRotting(grid));

    }


}
