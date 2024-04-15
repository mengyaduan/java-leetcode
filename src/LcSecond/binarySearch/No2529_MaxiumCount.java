package LcSecond.binarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/?envType=daily-question&envId=2024-04-09">正整数和负整数的最大计数</a>
 **/
public class No2529_MaxiumCount {
    public int maximumCount(int[] nums) {
        // 找到第一个大于零的数和第一个小于零的数，比较大小即可
        int firstLtZero = -1;
        int firstGtZero = -1;
        int l = 0;
        int r = nums.length - 1;
        // 先找到最小的 大于0的数
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > 0) {
                firstGtZero = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int gt = firstGtZero == -1 ? 0 : nums.length - firstGtZero;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0) {
                firstLtZero = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int lt = firstLtZero == -1 ? 0 : firstLtZero + 1;
        return Math.max(gt, lt);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{-2, -1, -1, 1, 2, 3};
        Assert.assertEquals(maximumCount(nums), 3);
        int[] n2 = new int[]{-3, -2, -1, 0, 0, 1, 2};
        Assert.assertEquals(maximumCount(n2), 3);

    }
}
