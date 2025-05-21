package Lc119;

import java.util.Arrays;

public class LCR088 {

    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dp(cost, 0), dp(cost, 1));
    }

    public int dp(int[] cost, int idx) {
        if (idx >= cost.length) {
            // 已到达顶端
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int a = dp(cost, idx + 1);
        int b = dp(cost, idx + 2);
        memo[idx] = cost[idx] + Math.min(a, b);
        return memo[idx];
    }


}
