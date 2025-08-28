package LC100Again;


public class Lc051 {

    public int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && memo[i][j] == 0) {
                    result++;
                    dfs(grid, m, n, i, j, memo);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int m, int n, int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || memo[i][j] == 1) {
            return;
        }
        // 标记已访问
        memo[i][j] = 1;
        // 分别访问上下左右未访问节点，如果是1，则标记，否则跳过
        dfs(grid, m, n, i - 1, j, memo);
        dfs(grid, m, n, i + 1, j, memo);
        dfs(grid, m, n, i, j - 1, memo);
        dfs(grid, m, n, i, j + 1, memo);
    }


}
