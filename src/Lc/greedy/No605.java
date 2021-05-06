package Lc.greedy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/can-place-flowers/</a>
 */
public class No605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cursor = 0;
        if (n == 0) {
            return true;
        }
        if (len == 1) {
            return flowerbed[0] != 1;
        }
        while (cursor < len) {
            boolean isMatch = false;
            if (flowerbed[cursor] == 0) {
                if (cursor == 0 && flowerbed[cursor + 1] == 0) {
                    isMatch = true;
                }
                if (cursor == (len - 1) && flowerbed[cursor - 1] == 0) {
                    isMatch = true;
                }
                if (cursor > 1 && cursor < (len - 1) && flowerbed[cursor - 1] == 0 && flowerbed[cursor + 1] == 0) {
                    isMatch = true;
                }
            }
            if (isMatch) {
                flowerbed[cursor] = 1;
                n--;
                if (n <= 0) {
                    return true;
                }
            }
            cursor++;
        }
        return false;
    }

    @DataProvider(name = "driver")
    public Object[][] driver() {
        Object[][] data = {
//                {new int[]{1, 0, 0, 0, 1}, 1, true},
//                {new int[]{1, 0, 0, 0, 1}, 2, false},
//                {new int[]{1, 0, 0, 0, 1}, 3, false},
//                {new int[]{1, 0, 0, 0, 1}, 0, true},
//                {new int[]{1, 0, 0, 1, 1}, 1, false},
//                {new int[]{1, 0, 0, 1, 1}, 2, false},
//                {new int[]{1, 0, 0, 1, 1}, 3, false},
//                {new int[]{1, 0, 0, 0, 0}, 3, true},
//                {new int[]{1, 0, 0, 0, 0}, 2, true},
//                {new int[]{1, 0, 0, 0, 0}, 1, true},
//                {new int[]{1, 0}, 1, false},
//                {new int[]{0}, 1, true},
//                {new int[]{1}, 1, false},
                {new int[]{1, 0, 0, 0, 0, 1}, 2, false},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "driver")
    public void test(int[] data, int n, boolean res) throws Exception {
        boolean result = canPlaceFlowers(data, n);
        Assert.assertEquals(result, res);
    }

}
