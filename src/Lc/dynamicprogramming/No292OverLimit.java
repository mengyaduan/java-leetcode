package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/nim-game/">nim game</a>
 **/
public class No292OverLimit {

    int[] memo;

    public boolean canWinNim(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, 0);
        return pick(n);
    }

    public boolean pick(int leftN) {
        if (leftN <= 3) {
            return true;
        }
        if (memo[leftN] != 0) {
            return memo[leftN] == 1;
        }
        boolean res = pick(leftN - 1) && pick(leftN - 2) && pick(leftN - 3);
        memo[leftN] = res ? -1 : 1;
        return memo[leftN] == 1;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {3, true},
                {1, true},
                {4, false},
                {5, true},
                {6, true},
                {7, true},
                {8, false},
        };
    }

    @Test(description = "单测", dataProvider = "unit")
    public void test(int n, boolean res) throws Exception {
        boolean cal = canWinNim(n);
        Assert.assertEquals(cal, res);
    }
}
