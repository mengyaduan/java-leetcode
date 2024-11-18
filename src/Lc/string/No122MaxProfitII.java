package Lc.string;

import org.testng.annotations.Test;

public class No122MaxProfitII {

    public int maxProfit(int[] prices) {
        int[][] table = new int[prices.length][2];
        table[0][0] = 0;
        table[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            table[i][0] = Math.max(table[i - 1][0], table[i - 1][1] + prices[i]);
            table[i][1] = Math.max(table[i - 1][1], table[i - 1][0] - prices[i]);
        }
        return table[prices.length - 1][0];
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
