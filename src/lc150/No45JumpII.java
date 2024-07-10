package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No45JumpII {

    int memo[];

    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -2);
        return dp(nums, 0);
    }

    // 返回从pos开始，到终点的最小跳数，如果到不了终点，返回-1
    public int dp(int[] nums, int pos) {
        if (pos == nums.length - 1) {
            return 0;
        }
        if (pos > nums.length - 1 || nums[pos] == 0) {
            // 超出目标不可达，当前位置为0不可达
            return -1;
        }
        if (memo[pos] != -2) {
            // 非初始化状态，此时直接返回
            return memo[pos];
        }

        int step = nums[pos];
        // 从pos+1开始走，选出最小的次数
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= step; i++) {
            int item = dp(nums, pos + i);
            if (item >= 0) {
                // 只有pos大于等于0时，才需要比较
                res = Math.min(item + 1, res);
            }
        }
        if (res == Integer.MAX_VALUE) {
            // 永远不可达，此时标记为-1
            res = -1;
        }
        memo[pos] = res;
        return res;
    }


    @Test(description = "")
    public void test() throws Exception {

        Assert.assertEquals(jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}), 3);
        Assert.assertEquals(jump(new int[]{2, 0, 2, 0, 1}), 2);
        Assert.assertEquals(jump(new int[]{2, 3, 1, 1, 4}), 2);
        Assert.assertEquals(jump(new int[]{2, 3, 0, 1, 4}), 2);
    }


}
