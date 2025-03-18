package Lc119;


import org.testng.annotations.Test;

public class LCR008 {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (left < nums.length) {
            if (sum >= target || right == nums.length) {
                // 收缩窗口
                if (sum >= target) {
                    result = Math.min(result, right - left);
                }
                sum -= nums[left];
                left++;
            } else {
                // 扩张窗口
                sum += nums[right];
                right += 1;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

    }
}
