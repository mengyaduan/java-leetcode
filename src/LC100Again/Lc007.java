package LC100Again;


import org.testng.annotations.Test;

public class Lc007 {
    public int trap(int[] height) {
        int result = 0;
        int left = height[0];
        int rightIdx = 1;
        // 先从左到右找
        int temp = 0;
        while (rightIdx < height.length) {
            int cur = height[rightIdx];
            if (cur < left) {
                temp += left - cur;
            } else {
                result += temp;
                left = cur;
                temp = 0;
            }
            rightIdx++;
        }
        temp = 0;
        // 接下来从右往左找
        int right = height[height.length - 1];
        int leftIdx = height.length - 2;
        while (leftIdx >= 0) {
            int cur = height[leftIdx];
            if (cur <= right) {
                temp += right - cur;
            } else {
                result += temp;
                right = cur;
                temp = 0;
            }
            leftIdx--;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(trap(new int[]{5, 4, 1, 2}));

    }

}
