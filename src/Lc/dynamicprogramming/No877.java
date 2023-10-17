package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/stone-game/description/">stone-game</a>
 **/
public class No877 {

    public boolean stoneGame(int[] piles) {
        return true;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
        };
    }

    @Test(description = "单测", dataProvider = "unit")
    public void test(int[] n, boolean res) throws Exception {
        boolean cal = stoneGame(n);
        Assert.assertEquals(cal, res);
    }
}
