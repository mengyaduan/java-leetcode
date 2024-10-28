package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No42 {

    int result = 0;

    public int trap(int[] height) {
        result = 0;
        if (height.length <= 2) {
            return result;
        }
        // 从左到右，计算小于等于的
        int idx = 0;
        while (idx < height.length) {
            idx = idxLeft2Right(height, idx);
        }
        // 从右到左，仅计算小于的
        idx = height.length - 1;
        while (idx >= 0) {
            idx = idxRight2Left(height, idx);
        }
        return result;
    }

    public int idxLeft2Right(int[] height, int cur) {
        int top = height[cur];
        int i = cur + 1;
        int tempSum = 0;
        while (i < height.length && height[i] <= top) {
            tempSum += top - height[i];
            i++;
        }
        if (i < height.length) {
            result += tempSum;
        }
        return i;
    }

    public int idxRight2Left(int[] height, int cur) {
        int top = height[cur];
        int tempSum = 0;
        int i = cur - 1;
        while (i >= 0 && height[i] < top) {
            tempSum += top - height[i];
            i--;
        }
        if (i >= 0) {
            result += tempSum;
        }
        return i;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
        Assert.assertEquals(trap(new int[]{4, 2, 0, 3, 2, 5}), 9);
        Assert.assertEquals(trap(new int[]{4, 2, 0, 5, 2, 3}), 7);
    }
}
