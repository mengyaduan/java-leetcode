package LC100Again;


public class Lc013 {

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}
