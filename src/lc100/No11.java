package lc100;

import org.testng.annotations.Test;

public class No11 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int result = 0;
        while (i < j) {
            int item;
            if (height[i] < height[j]) {
                item = height[i] * (j - i);
                i++;
            } else {
                item = height[j] * (j - i);
                j--;
            }
            result = Math.max(item, result);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 4, 7}));
        System.out.println(maxArea(new int[]{1, 2}));
    }
}
