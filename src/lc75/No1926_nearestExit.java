package lc75;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75">迷宫离入口最近的出口</a>
 */
public class No1926_nearestExit {

    int[][] memo;

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        maze[entrance[0]][entrance[1]] = '+';
        Deque<int[]> helper = new ArrayDeque<>();
        // 初始化数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean hasChanged = update(maze, m, n, i, j);
                // 只要节点变更过，那么就把这个节点四周的节点都放到待处理队列
                if (hasChanged) {
                    ArrayList<int[]> points = getPointAround(maze, m, n, i, j);
                    helper.addAll(points);
                }
            }
        }
        while (!helper.isEmpty()) {
            // 取出节点，处理
            int[] node = helper.pollFirst();
            boolean hasChanged = update(maze, m, n, node[0], node[1]);
            if (hasChanged) {
                ArrayList<int[]> points = getPointAround(maze, m, n, node[0], node[1]);
                helper.addAll(points);
            }
        }
        int res = Integer.MAX_VALUE;
        ArrayList<int[]> p = getPointAround(maze, m, n, entrance[0], entrance[1]);
        if (p.size() == 0) {
            // 周围没有点
            return -1;
        }
        for (int[] item : p) {
            res = Math.min(res, memo[item[0]][item[1]]);
        }
        return res == Integer.MAX_VALUE ? -1 : res + 1;
    }

    private boolean update(char[][] maze, int m, int n, int i, int j) {
        // 不可能越界，如果是+，则直接返回max；如果是边上，直接返回0，其他则需要比较四周，取最小值+1
        // Note 如果四周都是正无穷，此时返回正无穷
        if (maze[i][j] == '+') {
            memo[i][j] = Integer.MAX_VALUE;
            return false;
        }
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            if (memo[i][j] > 0) {
                memo[i][j] = 0;
                return true;
            } else {
                return false;
            }
        }
        int res = Math.min(Math.min(memo[i][j + 1], memo[i][j - 1]), Math.min(memo[i + 1][j], memo[i - 1][j]));
        if (res == Integer.MAX_VALUE) {
            memo[i][j] = Integer.MAX_VALUE;
            return false;
        } else {
            if (res + 1 < memo[i][j]) {
                memo[i][j] = res + 1;
                return true;
            } else {
                return false;
            }
        }
    }

    public ArrayList<int[]> getPointAround(char[][] maze, int m, int n, int i, int j) {
        ArrayList<int[]> res = new ArrayList<>();
        if (i + 1 < m && maze[i + 1][j] != '+') {
            res.add(new int[]{i + 1, j});
        }
        if (i - 1 >= 0 && maze[i - 1][j] != '+') {
            res.add(new int[]{i - 1, j});
        }
        if (j + 1 < n && maze[i][j + 1] != '+') {
            res.add(new int[]{i, j + 1});
        }
        if (j - 1 >= 0 && maze[i][j - 1] != '+') {
            res.add(new int[]{i, j - 1});
        }
        return res;
    }

    @Test(description = "")
    public void test3() throws Exception {
        char[][] maze = new char[][]{
                {'.', '+'}
        };
        Assert.assertEquals(nearestExit(maze, new int[]{0, 0}), -1);
    }


    @Test(description = "")
    public void test2() throws Exception {
        char[][] maze = new char[][]{
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        Assert.assertEquals(nearestExit(maze, new int[]{1, 0}), 2);
    }

    @Test(description = "")
    public void test() throws Exception {
        char[][] maze = new char[][]{
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        Assert.assertEquals(nearestExit(maze, new int[]{1, 2}), 1);
    }

}
