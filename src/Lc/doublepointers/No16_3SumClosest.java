package Lc.doublepointers;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/3sum-closest/description/">最接近的3数之和</a>
 **/
public class No16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int[] res = new int[nums.length];
        int delta = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            res[i] = nums[i] + closestTwoSum(nums, target - nums[i], i + 1, nums.length - 1);
            int item = Math.abs(res[i] - target);
            if (item < delta) {
                delta = item;
                result = res[i];
            }
        }
        return result;
    }

    public int closestTwoSum(int[] nums, int target, int left, int right) {
        int minDiff = Integer.MAX_VALUE;
        int closest = 0;
        while (left < right) {
            int item = nums[left] + nums[right];
            int diff = Math.abs(item - target);
            if (diff < minDiff) {
                minDiff = diff;
                closest = item;
            }
            if (item > target) {
                int cur = right - 1;
                while (cur > left && nums[cur] == nums[right]) {
                    cur--;
                }
                right = cur;
            } else if (item < target) {
                int cur = left + 1;
                while (cur < right && nums[cur] == nums[left]) {
                    cur++;
                }
                left = cur;
            } else {
                return item;
            }
        }
        return closest;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(closestTwoSum(new int[]{-5, -2, 0, 4, 7, 12}, 11, 1, 5));
        System.out.println(threeSumClosest(new int[]{-5, -2, 0, 4, 7, 12}, 6));

    }
}

