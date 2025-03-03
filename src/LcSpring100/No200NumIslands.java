package LcSpring100;

public class No200NumIslands {

    int[][] visited;

    public int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || visited[i][j] != 0) {
                    continue;
                }
                bfs(grid, m, n, i, j);
                result += 1;
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int m, int n, int i, int j) {
        // 如果越界，或者节点为0，或者已经处理过了，则直接return
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j] != 0) {
            return;
        }
        // 否则将节点标记为已经访问，将其上下左右加入到待check
        visited[i][j] = 1;
        bfs(grid, m, n, i - 1, j);
        bfs(grid, m, n, i + 1, j);
        bfs(grid, m, n, i, j - 1);
        bfs(grid, m, n, i, j + 1);
    }


}
