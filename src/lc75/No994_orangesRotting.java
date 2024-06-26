package lc75;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75">腐烂的句子</a>
 */
public class No994_orangesRotting {
    Deque<int[]> helper;
    int turnBad;

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int good = 0;
        helper = new ArrayDeque<>();
        // 需要记录健康橘子总数，同时初始化数据，将坏橘子扔进队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    good++;
                }
                if (grid[i][j] == 2) {
                    helper.addLast(new int[]{i, j});
                }
            }
        }
        if (good == 0) {
            return 0;
        }
        if (helper.isEmpty()) {
            // 没有坏的
            return -1;
        }
        int minutes = 0;
        turnBad = 0;
        while (!helper.isEmpty()) {
            int turnNow = turnBad;
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                int[] node = helper.pollFirst();
                infect(grid, m, n, node[0], node[1]);
            }
            // 仅当本轮有橘子被感染时，才应该++
            if (turnNow != turnBad) {
                minutes++;
            }
        }
        // 腐化的数量要与健康橘子相等时，返回分钟数，否则返回-1
        return good == turnBad ? minutes : -1;
    }

    private void infect(int[][] grid, int m, int n, int i, int j) {
        // i，j感染周边的四个未被感染的橘子
        if (i + 1 < m) beInfected(grid, i + 1, j);
        if (i - 1 >= 0) beInfected(grid, i - 1, j);
        if (j + 1 < n) beInfected(grid, i, j + 1);
        if (j - 1 >= 0) beInfected(grid, i, j - 1);
    }

    private void beInfected(int[][] grid, int x, int y) {
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            turnBad++;
            helper.addLast(new int[]{x, y});
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] grid = new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));

    }


}
