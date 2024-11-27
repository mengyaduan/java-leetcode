package lc100;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class No121 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minInput = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minInput = Math.min(minInput, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minInput);
        }
        return maxProfit;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{7, 1, 5, 3, 4, 6}, 5},
                {new int[]{7, 2, 5, 3, 1, 6}, 5},
                {new int[]{7, 6, 5, 4, 3}, 0},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int expected) {
        int res = maxProfit(m);
        Assert.assertEquals(res, expected);
    }
}
