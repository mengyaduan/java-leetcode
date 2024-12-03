package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class No322 {


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(coinChange(new int[]{1, 2, 5}, 12), 3);
        Assert.assertEquals(coinChange(new int[]{2}, 3), -1);
        Assert.assertEquals(coinChange(new int[]{2}, 2), 1);

    }


}
