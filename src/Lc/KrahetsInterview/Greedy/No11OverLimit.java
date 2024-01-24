package Lc.KrahetsInterview.Greedy;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/description/">最大水容量</a>
 **/
public class No11OverLimit {

    public int maxArea(int[] height) {
        int maxRes = Integer.MIN_VALUE;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = (i - j) * Math.min(height[i], height[j]);
                maxRes = Math.max(maxRes, temp);
            }
        }
        return maxRes;
    }


}

