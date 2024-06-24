package lc75;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75">省份数量</a>
 */
public class No547_findCircleNum {

    int[] memo;
    int count;

    public int findCircleNum(int[][] isConnected) {
        count = 0;
        int n = isConnected.length;
        memo = new int[n];
        for (int i = 0; i < n; i++) {
            if (memo[i] == 0) {
                // 某个城市没有被访问过，此时开始新的省份圈选
                count++;
                visit(isConnected, i);
            }
        }
        return count;
    }

    private void visit(int[][] isConnected, int i) {
        memo[i] = 1;
        ArrayList<Integer> toBeVisited = new ArrayList<>();
        for (int j = 0; j < isConnected.length; j++) {
            if (i == j) {
                continue;
            }
            if (isConnected[i][j] == 1 && memo[j] == 0) {
                toBeVisited.add(j);
            }
        }
        for (int item : toBeVisited) {
            visit(isConnected, item);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] isConnected = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));

    }
}
