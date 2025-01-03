package lc100;

public class No64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] table = new int[m][n];
        table[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            table[i][0] = table[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            table[0][j] = table[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = grid[i][j] + Math.min(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[m - 1][n - 1];
    }
}
