package Lc.string;

import org.testng.annotations.Test;

public class No121MaxProfit {

    public int maxProfit(int[] prices) {
        int result = 0;
        int[][][] table = new int[prices.length][2][2];
        table[0][0][0] = 0;
        table[0][1][0] = 0;
        table[0][0][1] = 0;
        table[0][1][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            table[i][0][0] = Math.max(table[i - 1][0][0], table[i - 1][1][1] + prices[i]);
            table[i][0][1] = 0;
            table[i][1][0] = 0;
            table[i][1][1] = Math.max(table[i - 1][1][1], table[i - 1][0][1] - prices[i]);
            result = Math.max(result, table[i][0][0]);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }
}
