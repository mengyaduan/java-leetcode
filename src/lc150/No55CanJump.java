package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No55CanJump {
    int[] memo;

    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        return dp(nums, 0);
    }

    private boolean dp(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        if (i > nums.length - 1) {
            return false;
        }
        if (memo[i] != 0) {
            // 1=true
            return memo[i] == 1;
        }
        int count = nums[i];
        boolean res = false;
        for (int j = 1; j <= count; j++) {
            res = res || dp(nums, i + j);
            if (res) {
                break;
            }
        }
        memo[i] = res ? 1 : 2;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(canJump(new int[]{2, 3, 1, 1, 4}), true);
        Assert.assertEquals(canJump(new int[]{3, 2, 1, 0, 4}), false);

    }

}
