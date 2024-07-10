package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No121MaxProfit {

    public int maxProfit(int[] prices) {
        int yesterday0 = 0;
        int yesterday1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            yesterday0 = Math.max(yesterday0, prices[i] + yesterday1);
            yesterday1 = Math.max(yesterday1, -prices[i]);
        }
        return yesterday0;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        Assert.assertEquals(maxProfit(new int[]{7, 6, 4, 3, 1}), 0);

    }
}
