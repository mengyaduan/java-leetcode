package Lc119;

public class LCR105 {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, expand(grid, i, j));
            }
        }
        return result;
    }

    private int expand(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int res = 1;
        grid[i][j] = 0;
        if (i - 1 >= 0) {
            res += expand(grid, i - 1, j);
        }
        if (i + 1 < grid.length) {
            res += expand(grid, i + 1, j);
        }
        if (j - 1 >= 0) {
            res += expand(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length) {
            res += expand(grid, i, j + 1);
        }
        return res;
    }

}
