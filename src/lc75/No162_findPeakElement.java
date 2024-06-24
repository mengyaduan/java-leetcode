package lc75;

/**
 * @see <a href="https://leetcode.cn/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75">寻找峰值</a>
 */
public class No162_findPeakElement {

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

            int m = nums[mid];
            int ml = nums[mid - 1];
            int mr = nums[mid + 1];

            if (m > ml && m > mr) {
                return mid;
            } else if (m > ml && m < mr) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
