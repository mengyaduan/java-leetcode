package LC100Again;


public class Lc065 {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int start = -1, end = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    start = mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    end = mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{start, end};
    }

}
