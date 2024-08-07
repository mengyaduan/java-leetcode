package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No909SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        // 构建图，用一个节点和list表示？
        int n = board.length;
        HashMap<Integer, GraphNode> helper = new HashMap<>();
        createGraph(board, n, helper);
        // 从1开始遍历图，找到最小能够抵达n*n的步数
        // 定义一个int[]，记录从1到idx需要的步数，不断更新即可
        int[] memo = new int[n * n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[1] = 0;
        // 去重
        Deque<Integer> q = new ArrayDeque<>();
        q.push(1);
        int stepFrom1 = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.pollFirst();
                GraphNode item = helper.get(idx);
                for (int nextStep : item.next) {
                    // 如果路径值被更新，则需要加进待处理队列
                    if (memo[nextStep] > stepFrom1 + 1) {
                        memo[nextStep] = stepFrom1 + 1;
                        q.add(nextStep);
                    }
                }
            }
            stepFrom1++;
        }
        return memo[n * n] == Integer.MAX_VALUE ? -1 : memo[n * n];
    }

    private void createGraph(int[][] board, int n, HashMap<Integer, GraphNode> helper) {
        HashMap<Integer, Integer> idxWithBoardV = new HashMap<>();
        int count = 0;
        boolean left2right = true;
        // 初始化所有的节点，录入map
        for (int i = n - 1; i >= 0; i--) {
            if (left2right) {
                for (int j = 0; j < n; j++) {
                    count++;
                    idxWithBoardV.put(count, board[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    count++;
                    idxWithBoardV.put(count, board[i][j]);
                }
            }
            left2right = !left2right;
        }
        // 给每个节点的next赋值
        for (int i = 1; i <= n * n; i++) {
            GraphNode item = new GraphNode(i);
            for (int k = 1; k <= 6; k++) {
                int cur = i + k;
                if (cur <= n * n) {
                    int nextStep = idxWithBoardV.get(cur);
                    if (nextStep != -1) {
                        item.next.add(nextStep);
                    }else {
                        item.next.add(cur);
                    }
                }
                helper.put(i, item);
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        Assert.assertEquals(snakesAndLadders(board), 4);
    }

    @Test(description = "")
    public void test2() throws Exception {
        int[][] matrix = {
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1}
        };
        Assert.assertEquals(snakesAndLadders(matrix), -1);

    }
}


class GraphNode {
    int val;
    HashSet<Integer> next;

    public GraphNode(int _val) {
        this.val = _val;
        next = new HashSet<>();
    }

}
