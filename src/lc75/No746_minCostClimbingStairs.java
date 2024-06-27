package lc75;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75">最小花费爬楼梯</a>
 */
public class No746_minCostClimbingStairs {


    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return cost[0] < cost[1] ? cost[0] : cost[1];
        }
        int n = cost.length;
        int[] memo = new int[n];
        memo[0] = cost[0];
        memo[1] = cost[1];
        for (int i = 2; i < n; i++) {
            memo[i] = Math.min(memo[i - 1] + cost[i], memo[i - 2] + cost[i]);
        }
        return Math.min(memo[n - 1], memo[n - 2]);
    }

    @Test(description = "")
    public void test1() throws Exception {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Assert.assertEquals(minCostClimbingStairs(cost), 6);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] cost = new int[]{10, 15, 20};
        Assert.assertEquals(minCostClimbingStairs(cost), 15);
    }
}
