package Lc.KrahetsInterview.Math;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=selected-coding-interview">找众数</a>
 **/
public class No169_MajorityElement {

    public int majorityElement(int[] nums) {
        int sum = 0;
        int me = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                me = nums[i];
                sum = 1;
                continue;
            }
            sum += nums[i] == me ? 1 : -1;
        }
        return me;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(majorityElement(new int[]{6, 5, 5}));
    }

}

