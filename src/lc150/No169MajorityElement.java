package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No169MajorityElement {

    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            } else if (nums[i] != cur && count > 0) {
                count--;
            } else {
                cur = nums[i];
                count = 1;
            }
        }
        return cur;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}), 2);
        Assert.assertEquals(majorityElement(new int[]{3, 2, 3}), 3);
    }
}
