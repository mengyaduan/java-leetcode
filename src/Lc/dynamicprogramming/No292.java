package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/nim-game/">nim game</a>
 **/
public class No292 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {1, true},
                {2, true},
                {3, true},
                {4, false},
                {5, true},
                {6, true},
                {7, true},
                {8, false},
                {9, true},
                {10, true},
                {1348820612, false},
        };
    }

    @Test(description = "单测", dataProvider = "unit")
    public void test(int n, boolean res) throws Exception {
        boolean cal = canWinNim(n);
        Assert.assertEquals(cal, res);
    }
}
