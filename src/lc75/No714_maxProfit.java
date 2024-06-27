package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75">股票买卖-手续费</a>
 */
public class No714_maxProfit {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] memo = new int[prices.length + 1][2];
        memo[0][0] = 0;
        memo[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] + prices[i] - fee);
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] - prices[i]);
        }
        return memo[prices.length - 1][0];
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));

    }

}
