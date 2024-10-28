package lc100;

import org.testng.annotations.Test;

public class No53 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int lastValue = result;
        for (int i = 1; i < nums.length; i++) {
            if (lastValue > 0) {
                lastValue += nums[i];
            } else {
                lastValue = nums[i];
            }
            result = Math.max(result, lastValue);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }
}
