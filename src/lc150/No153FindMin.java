package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No153FindMin {

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[n - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(findMin(new int[]{3}), 3);
        Assert.assertEquals(findMin(new int[]{3, 4, 5, 1, 2}), 1);

    }
}
