package lc75;


import org.testng.annotations.Test;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

/**
 * @see <a href="https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=study-plan-v2&envId=leetcode-75">重新规划路线</a>
 */
public class No1466_minReorder {

    public int minReorderOverLimit(int n, int[][] connections) {
        int count = 0;
        int[] memo = new int[connections.length];
        Deque<Integer> helper = new ArrayDeque<>();
        helper.add(0);
        while (!helper.isEmpty()) {
            int item = helper.pollFirst();
            for (int i = 0; i < connections.length; i++) {
                if (memo[i] == 1) {
                    continue;
                }
                int start = connections[i][0];
                int end = connections[i][1];
                if (end == item) {
                    memo[i] = 1;
                    // 如果是指向目标点的，则可以加进名单
                    helper.push(start);
                }
                if (start == item) {
                    count += 1;
                    // 转向后，加入新的数据
                    memo[i] = 1;
                    helper.push(end);
                }
            }
        }
        return count;
    }

    public int minReorder(int n, int[][] connections) {
        // A2B存储抵达B的节点，B2A存储B开始的节点
        ArrayList<Integer>[] pathA2B = new ArrayList[n];
        ArrayList<Integer>[] pathB2A = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            pathA2B[i] = new ArrayList<>();
            pathB2A[i] = new ArrayList<>();
        }
        for (int[] item : connections) {
            pathA2B[item[1]].add(item[0]);
            pathB2A[item[0]].add(item[1]);
        }
        int count = 0;
        HashSet<Integer> helper = new HashSet<>();
        helper.add(0);
        Deque<Integer> toAdd = new ArrayDeque<>();
        toAdd.add(0);
        while (helper.size() != n) {
            int target = toAdd.pollFirst();
            // 将所有直接到达0的节点加入到helper中
            for (Integer item : pathA2B[target]) {
                helper.add(item);
                toAdd.push(item);
            }
            // 将所有0直连的节点，加入到helper，此时已经转向
            for (Integer item : pathB2A[target]) {
                if (helper.contains(item)) {
                    continue;
                }
                count++;
                helper.add(item);
                toAdd.push(item);
            }
        }
        return count;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] connections = new int[][]{
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5},
        };
        System.out.println(minReorder(6, connections));

    }


}
