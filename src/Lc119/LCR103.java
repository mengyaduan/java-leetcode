package Lc119;

import org.testng.annotations.Test;

public class LCR103 {

    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        return dp(coins, amount, cache);
    }

    public int dp(int[] coins, int amountLeft, int[] cache) {
        if (amountLeft < 0) {
            return -1;
        }
        if (amountLeft == 0) {
            return 0;
        }
        if (cache[amountLeft] != 0) {
            return cache[amountLeft] == Integer.MAX_VALUE ? -1 : cache[amountLeft];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int item = dp(coins, amountLeft - coin, cache);
            if (item >= 0) {
                res = Math.min(res, item + 1);
            }
        }
        cache[amountLeft] = res;
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            int len = coins.length;
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < len; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(coinChange(new int[]{2}, 3));

    }
}
