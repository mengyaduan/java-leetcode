package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int start = nums[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < start) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l % nums.length];
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(findMin(new int[]{11, 13, 15, 17}), 11);
    }


}
