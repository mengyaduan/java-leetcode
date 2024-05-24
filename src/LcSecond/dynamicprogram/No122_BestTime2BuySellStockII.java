package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/">买卖股票2</a>
 */
public class No122_BestTime2BuySellStockII {
    int[][] memo;

    public int maxProfit(int[] prices) {
        memo = new int[prices.length + 1][2];
        memo[1][0] = 0;
        memo[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][1] + prices[i - 1], memo[i - 1][0]);
            memo[i][1] = Math.max(memo[i - 1][0] - prices[i - 1], memo[i - 1][1]);
        }
        return memo[prices.length][0];
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

    }
}
