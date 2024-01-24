package Lc.KrahetsInterview.Greedy;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/description/">最大水容量</a>
 **/
public class No11 {

    public int maxArea(int[] height) {
        int maxRes = Integer.MIN_VALUE;
        int previous = height[0];
        for (int i = 0; i < height.length; i++) {
            if (height[i] < previous) {
                // 如果比之前的还低，那肯定不可能有最大值，直接跳过
                continue;
            }
            previous = height[i];
            for (int j = i + 1; j < height.length; j++) {
                maxRes = Math.max(maxRes, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxRes;
    }

    public int maxAreaAns(int[] height) {
        int maxRes = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            maxRes = Math.max(maxRes, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxRes;
    }

}

