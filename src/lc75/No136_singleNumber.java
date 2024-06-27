package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=leetcode-75">只出现一次的数字</a>
 */
public class No136_singleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int item : nums) {
            res = res ^ item;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(singleNumber(new int[]{1, 2, 2, 1, 5, 3, 3, 4, 4}));


    }
}
