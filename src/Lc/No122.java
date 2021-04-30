package Lc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/"</a>
 **/
public class No122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        if (len <= 1) {
            return profit;
        }
        int[] tendency = new int[len];
        tendency[0] = prices[0] <= prices[1] ? -1 : 1;
        for (int i = 1; i < len; i++) {
            tendency[i] = prices[i - 1] < prices[i] ? 1 : -1;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < len - 1; i++) {
            if (tendency[i] == -1 && tendency[i + 1] == 1) {
                left = i;
                int j = left + 1;
                while (j < len) {
                    if (tendency[j] == -1) {
                        break;
                    }
                    j++;
                }
                right = j - 1;
                profit += prices[right] - prices[left];
                i = right;
            }
        }
        return profit;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                // 
                {new int[]{7, 1, 5, 3, 6, 4}, 7},
                {new int[]{1, 2, 3, 4, 5, 6}, 5},
                {new int[]{5, 4, 3, 2}, 0},
                {new int[]{5}, 0},
                {new int[]{1, 1, 1, 1, 1, 1, 1}, 0},
                {new int[]{1, 2, 1, 1, 1, 1, 1}, 1},
                {new int[]{2, 2, 5}, 3},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] prices, int res) throws Exception {
        int result = maxProfit(prices);
        Assert.assertEquals(res, result, "预期输出：" + res + "\n实际输出:" + result);
    }
}
