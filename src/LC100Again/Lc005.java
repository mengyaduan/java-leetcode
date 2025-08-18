package LC100Again;


public class Lc005 {
    public int maxArea(int[] height) {
        // 只能缩矮的那边
        int i = 0, j = height.length - 1;
        int result = 0;
        while (i < j) {
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

}
