package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">买卖股票</a>
 **/
public class No121 {

    public int maxProfit(int[] prices) {
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


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{7, 1, 5, 3, 4, 6}, 5},
                {new int[]{7, 2, 5, 3, 1, 6}, 5},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int expected) {
        int res = maxProfit(m);
        Assert.assertEquals(res, expected);
    }

}
