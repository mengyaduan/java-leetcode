package LcSecond.binarySearch;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/find-peak-element/description/">找到峰值</a>
 **/
public class No162_FindPeak {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int l = 1, r = nums.length - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid - 1]) {
                r = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));

    }
}
