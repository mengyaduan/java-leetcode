package Lc119;

import org.testng.annotations.Test;

import java.util.Arrays;

public class LCR104 {

    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        int res = dp(nums, target, memo);
        return res;
    }


    public int dp(int[] nums, int target, int[] memo) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            res += dp(nums, target - num, memo);
        }
        memo[target] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(combinationSum4(new int[]{9}, 3));
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(combinationSum4(new int[]{2, 1, 3}, 35));

    }


}
