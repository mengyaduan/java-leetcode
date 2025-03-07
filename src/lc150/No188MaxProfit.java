package lc150;

import org.testng.annotations.Test;

public class No188MaxProfit {

    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] sell = new int[k];
        for (int i = 0; i < k; i++) {
            buy[i] = -prices[0];
            sell[i] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));


    }
}
