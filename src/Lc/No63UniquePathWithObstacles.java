package Lc;

public class No63UniquePathWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];
        table[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            table[i][0] = table[i - 1][0] == 0 ? 0 : (obstacleGrid[i][0] == 1 ? 0 : 1);
        }
        for (int j = 1; j < n; j++) {
            table[0][j] = table[0][j - 1] == 0 ? 0 : (obstacleGrid[0][j] == 1 ? 0 : 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = obstacleGrid[i][j] == 1 ? 0 : table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[m - 1][n - 1];
    }
}
