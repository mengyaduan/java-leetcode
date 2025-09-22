package LC100Again;


import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lc085 {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = dp(coins, amount, memo);
        return result == 10001 ? -1 : result;
    }

    private int dp(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }
        // amount最大10000
        int result = 10001;
        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            int item = dp(coins, amount - coin, memo);
            result = Math.min(item + 1, result);
        }
        memo[amount] = result;
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {

        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{3}, 0));
    }

}
