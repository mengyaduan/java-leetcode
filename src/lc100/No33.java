package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No33 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        // 第一次二分，找到k
        int l = 0, r = n - 1;
        // 比这个值大的，往右；否则往左
        int start = nums[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < start) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int k = l;
        // 第二次二分，查找target
        l = k;
        r = n - 1 + k;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int tempMid = mid >= n ? mid % n : mid;
            if (nums[tempMid] == target) {
                return tempMid;
            } else if (nums[tempMid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(search(new int[]{3, 1}, 1), 1);
        Assert.assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 0), 4);
        Assert.assertEquals(search(new int[]{4, 5, 6, 0, 1, 2, 3}, 0), 3);
        Assert.assertEquals(search(new int[]{4, 5, 6, 0, 1, 2, 3}, 6), 2);
    }
}
