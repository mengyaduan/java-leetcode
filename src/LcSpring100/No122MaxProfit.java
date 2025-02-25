package LcSpring100;

public class No122MaxProfit {


    public int maxProfit(int[] prices) {
        int[][] dpTable = new int[prices.length + 1][2];
        dpTable[0][0] = 0;
        dpTable[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dpTable[i][0] = Math.max(dpTable[i - 1][1] + prices[i - 1], dpTable[i - 1][0]);
            dpTable[i][1] = Math.max(dpTable[i - 1][0] - prices[i - 1], dpTable[i - 1][1]);
        }
        return dpTable[prices.length][0];
    }
}
