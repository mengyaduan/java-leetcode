package Lc.KrahetsInterview.DynamicProgram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">股票售卖</a>
 **/
public class No121 {
    int[][][] dpTable;

    public int maxProfit(int[] prices) {
        dpTable = new int[prices.length][2][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dpTable[i][1][0] = 0;
                dpTable[i][1][1] = Integer.MIN_VALUE;
                continue;
            }
            dpTable[i][1][0] = Math.max(dpTable[i - 1][1][0], dpTable[i - 1][1][1] + prices[i]);
            dpTable[i][1][1] = Math.max(dpTable[i - 1][1][1], -prices[i]);
        }

        return dpTable[prices.length - 1][1][0];
    }


    @Test(description = "")
    public void test() throws Exception {
        int res = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);

    }


}

