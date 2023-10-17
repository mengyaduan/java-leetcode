package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/bulb-switcher/description/">bulb-switcher</a>
 **/
public class No319 {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {1, 1},
                {2, 1},
                {3, 1},
                {4, 2},
                {5, 2},
                {6, 2},
                {7, 2},
                {8, 2},
                {9, 3},
                {3123, 55},
        };
    }

    @Test(description = "单测", dataProvider = "unit")
    public void test(int n, int res) throws Exception {
        int cal = bulbSwitch(n);
        Assert.assertEquals(cal, res);
    }
}
