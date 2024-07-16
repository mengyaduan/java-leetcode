package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No11MaxArea {

    public int maxArea(int[] height) {
        int ma = 0;
        int i = 0, j = height.length - 1;
        int pre = 0;
        while (i < j) {
            // 计算本轮的结果
            pre = height[i] <= height[j] ? height[i] : height[j];
            ma = Math.max(ma, pre * (j - i));
            // 收缩边界，找到新的i,j，至少要比当前的pre要大
            if (height[i] > height[j]) {
                while (i < j && height[j] <= pre) {
                    j--;
                }
            } else if (height[i] < height[j]) {
                while (i < j && height[i] <= pre) {
                    i++;
                }
            } else {
                while (i < j && height[i] <= pre) {
                    i++;
                }
                while (i < j && height[j] <= pre) {
                    j--;
                }
            }
        }
        return ma;
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
        Assert.assertEquals(maxArea(new int[]{1, 1}), 1);

    }
}
