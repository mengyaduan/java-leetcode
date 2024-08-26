package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No162FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int l = 1, r = n - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));

    }
}
