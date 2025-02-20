package LcSpring100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class No322CoinChange {

    int[] memo;
    HashMap<Integer, Integer> helper;

    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                amounts[coin] = 1;
            }
        }
        for (int i = 1; i < amounts.length; i++) {
            if (amounts[i] > 0) {
                continue;
            }
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin > 0 && amounts[i - coin] > 0) {
                    res = Math.min(res, amounts[i - coin] + 1);
                }
            }
            amounts[i] = res == Integer.MAX_VALUE ? -1 : res;
        }
        return amounts[amount];
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(coinChange(new int[]{186, 419, 83, 408}, 6249), 20);
        Assert.assertEquals(coinChange(new int[]{1, 2, 5}, 11), 3);
        Assert.assertEquals(coinChange(new int[]{2}, 3), -1);


    }
}
