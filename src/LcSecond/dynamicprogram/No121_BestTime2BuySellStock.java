package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">买卖股票</a>
 */
public class No121_BestTime2BuySellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minNow = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minNow) {
                minNow = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minNow, maxProfit);
            }
        }
        return maxProfit;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProfit(new int[]{7, 2, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{5, 4, 3, 2, 1}));


    }
}
