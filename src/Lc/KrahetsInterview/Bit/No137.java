package Lc.KrahetsInterview.Bit;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/single-number-ii/?envType=study-plan-v2&envId=selected-coding-interview">重复数字ii</a>
 **/
public class No137 {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        for (int item : nums) {
            int bit = 1;
            int count = 31;
            while (item != 0 && count >= 0) {
                if ((item & bit) == 1) {
                    res[count] += 1;
                }
                item >>= 1;
                count--;
            }
        }
        int result = 0;
        int base = 1;
        for (int i = 31; i >= 0; i--) {
            if (res[i] % 3 == 1) {
                result += base;
            }
            base *= 2;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}), 99);

    }
}

