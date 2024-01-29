package Lc.greedy;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/trapping-rain-water/description/"></a>
 **/
public class No42_TrappingRainWater {

    /**
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] <p> Output: 6<p>  Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     **/
    public int trap(int[] height) {
        int[] memo = new int[height.length];
        memo[0] = 0;
        for (int i = 1; i < height.length; i++) {
            memo[i] = calculateWater(i, height, memo);
        }
        return memo[height.length - 1];
    }

    public int calculateWater(int x, int[] height, int[] memo) {
        // 从x向左找：找到任意一个比height[x]高的 or 找到小于等于height[x]的最大的
        int flag = x - 1;
        int target = height[x];
        int leftSide = Integer.MIN_VALUE;
        int leftSideIndex = 0;
        while (flag >= 0) {
            if (height[flag] > target) {
                // case1- 找到比height[x]大的，例如0，1，2，3，2，1，5 -- 如果i=6，那么找到的将是3（3小于等于5，且最高）
                leftSideIndex = flag;
                break;
            } else {
                // case2- 没有大于height[x]的，找到最近接的，例如0，1，2，3，2，1，5 -- 如果i=5，那么找到的也是2（2是第一个大于1的，直接拦截了）
                if (height[flag] > leftSide) {
                    leftSideIndex = flag;
                    leftSide = height[flag];
                }
            }
            flag--;
        }
        int total = (x - leftSideIndex - 1) * Math.min(height[leftSideIndex], height[x]) + memo[leftSideIndex];
        for (int i = leftSideIndex + 1; i < x; i++) {
            total -= height[i];
        }
        return total;
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
        Assert.assertEquals(trap(new int[]{4, 2, 0, 3, 2, 5}), 9);
        Assert.assertEquals(trap(new int[]{1, 1, 1, 1, 1, 1}), 0);

    }
}
