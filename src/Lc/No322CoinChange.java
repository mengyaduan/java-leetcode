package Lc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.LambdaMetafactory;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashMap;

public class No322CoinChange {


    HashMap<Integer, Integer> memo;

    public int coinChangeComplex(int[] coins, int amount) {
        memo = new HashMap<>();
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = dp(coins, amount - coin);
            if (tmp >= 0) {
                res = Math.min(tmp + 1, res);
            }
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo.put(amount, res);
        return res;
    }

    public int coinChange(int[] coins, int amout) {
        int[] dpTable = new int[amout + 1];
        Arrays.fill(dpTable, 10099);
        dpTable[0] = 0;
        for (int i = 1; i < amout + 1; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dpTable[i] = Math.min(dpTable[i - coin] + 1, dpTable[i]);
                }
            }
        }
        return dpTable[amout] == 10099 ? -1 : dpTable[amout];
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(coinChange(new int[]{1, 2, 5}, 11), 3);
        Assert.assertEquals(coinChange(new int[]{2}, 3), -1);
        Assert.assertEquals(coinChange(new int[]{1}, 0), 0);

    }
}
