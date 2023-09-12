package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">买卖股票</a>
 **/
public class No121 {

    public int maxProfitComplicated(int[] prices) {
        int low = 0;
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[low]) {
                int temp = prices[i] - prices[low];
                if (temp > maxPro) {
                    maxPro = temp;
                }
            } else {
                low = i;
            }
        }
        return maxPro;
    }

    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length + 1][2];
        // 第一天以前，收益必为0
        memo[0][0] = 0;
        memo[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length + 1; i++) {
            // stay 或 卖出
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] + prices[i - 1]);
            // stay 或 买入
            memo[i][1] = Math.max(memo[i - 1][1], -prices[i - 1]);
        }
        return memo[prices.length][0];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{7, 1, 5, 3, 4, 6}, 5},
                {new int[]{7, 2, 5, 3, 1, 6}, 5},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int expected) {
        int res = maxProfit(m);
        Assert.assertEquals(res, expected);
    }

}
