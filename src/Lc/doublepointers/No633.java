package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/sum-of-square-numbers/"</a>
 **/
public class No633 {
    /**
     * 解题思路：一个非负整数是否能够表达为另外两个整数的平方和
     * 1. 开根并向下取整，得到upper
     * 2. 左游标从0开始，右游标从upper开始，进行判断
     * 3. 如果left*left+right*right>target，则右侧收缩；否则左侧收缩，直到left>right
     **/

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.floor(Math.sqrt(c));
        while (left <= right) {
            int now = left * left + right * right;
            if (now < c) {
                left++;
            } else if (now > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {5, true},
                {3, false},
                {4, true},
                {2, true},
                {1, true},
                {25, true},
                {24, false},
                {18, true},
                {0, true},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int c, boolean result) {
        boolean res = judgeSquareSum(c);
        Assert.assertEquals(res, result);
    }
}
