package lc150;

import org.testng.annotations.Test;

public class No123MaxProfit {


    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length <= 1) {
            return result;
        }
        // 天、剩余交易次数、是否持有
        int[][][] table = new int[prices.length][2][2];
        // 初始化
        table[0][1][1] = -prices[0];
        table[0][1][0] = Integer.MIN_VALUE;
        table[0][0][1] = Integer.MIN_VALUE;
        table[0][0][0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            // 交易一次
            table[i][1][1] = Math.max(-prices[i], table[i - 1][1][1]);
            table[i][1][0] = Math.max(table[i - 1][1][1] + prices[i], table[i - 1][1][0]);
            // 交易两次
            table[i][0][1] = table[i - 1][1][0] == Integer.MIN_VALUE ?
                    Integer.MIN_VALUE :
                    (Math.max(table[i - 1][1][0] - prices[i], table[i - 1][0][1]));
            table[i][0][0] = Math.max(table[i - 1][0][1] + prices[i], table[i - 1][0][0]);

            int curr = Math.max(table[i][0][0], table[i][1][0]);
            result = Math.max(result, curr);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));

    }
}
