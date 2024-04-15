package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/k-diff-pairs-in-an-array/description/">k个不同的分组</a>
 **/
public class No532_KDiffPairs {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i] + k;
            int l = i + 1, r = nums.length - 1;
            if (nums[l] > target || nums[r] < target) {
                continue;
            }
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    count++;
                    break;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return count;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{1, 3, 1, 5, 4};
        System.out.println(findPairs(nums, 0));
        System.out.println(findPairs(nums, 1));
        System.out.println(findPairs(nums, 2));

    }
}
