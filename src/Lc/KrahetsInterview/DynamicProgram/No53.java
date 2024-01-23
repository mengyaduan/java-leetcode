package Lc.KrahetsInterview.DynamicProgram;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray/description/">最大子数组和</a>
 **/
public class No53 {

    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        int maxRes = memo[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i], nums[i] + memo[i - 1]);
            if (memo[i] > maxRes) {
                maxRes = memo[i];
            }
        }
        return maxRes;
    }

}

