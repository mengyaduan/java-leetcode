package Lc.KrahetsInterview.DynamicProgram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/description/">打家劫舍</a>
 **/
public class No198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[][] memo = new int[nums.length][2];
        memo[0][0] = 0;
        memo[0][1] = nums[0];
        int maxRes = nums[0];

        for (int i = 1; i < memo.length; i++) {
            // 第i天不偷时，得到的最大利润
            memo[i][0] = Math.max(memo[i - 1][1], memo[i - 1][0]);
            // 第i天出手时，得到的最大利润
            memo[i][1] = memo[i - 1][0] + nums[i];
            if (memo[i][1] > maxRes) {
                maxRes = memo[i][1];
            }
        }
        return maxRes;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(rob(new int[]{2, 1, 1, 2}));

    }

}

