package lc75;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75">接水最多的容器</a>
 */
public class No11_maxArea {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxWater = 0;
        while (i < j) {
            // 计算当前水量
            maxWater = Math.max(Math.min(height[i], height[j]) * (j - i), maxWater);
            // 保留大的，移动小的
            if (height[i] < height[j]) {
                int item = height[i];
                while (i < j && height[i] <= item) {
                    i++;
                }
            } else {
                int item = height[j];
                while (i < j && height[j] <= item) {
                    j--;
                }
            }
        }
        return maxWater;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},
                {new int[]{1, 1}, 1},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] height, int res) throws Exception {
        Assert.assertEquals(maxArea(height), res);
    }
}
