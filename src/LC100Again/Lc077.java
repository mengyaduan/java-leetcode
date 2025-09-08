package LC100Again;


public class Lc077 {

    public int maxProfit(int[] prices) {
        int result = 0;
        int minIn = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minIn = Math.min(minIn, prices[i]);
            result = Math.max(result, prices[i] - minIn);
        }
        return result;
    }


}
