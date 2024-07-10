package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No42Trap {


    public int trap(int[] height) {
        int[][] memo = new int[height.length][height.length];
        int result = 0;
        int temp = 0;
        boolean flag = true;
        int idx = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[idx]) {
                result += temp;
                temp = 0;
                idx = i;
            }
            temp += height[idx] - height[i];
        }
        int end = idx;
        idx = height.length - 1;
        temp = 0;
        for (int i = height.length - 2; i >= end; i--) {
            if (height[i] >= height[idx]) {
                result += temp;
                temp = 0;
                idx = i;
            }
            temp += height[idx] - height[i];
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
        Assert.assertEquals(trap(new int[]{4, 2, 0, 3, 2, 5}), 9);
        Assert.assertEquals(trap(new int[]{2, 0, 2}), 2);
    }
}


