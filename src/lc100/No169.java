package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No169 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0 || last == nums[i]) {
                last = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return last;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}), 2);
        Assert.assertEquals(majorityElement(new int[]{2, 3, 2}), 2);
        Assert.assertEquals(majorityElement(new int[]{2, 2, 2, 2, 2, 3}), 2);

    }
}
