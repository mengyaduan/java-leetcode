package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75">打家劫舍</a>
 */
public class No198_houseRobber {


    public int rob(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][2];
        memo[0][0] = 0;
        memo[0][1] = nums[0];
        int res = Math.max(memo[0][0], memo[0][1]);
        for (int i = 1; i < n; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1]);
            memo[i][1] = memo[i - 1][0] + nums[i];
            res = Math.max(memo[i][0], memo[i][1]);
        }
        return res;
    }

    @Test(description = "")
    public void test1() throws Exception {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

}
