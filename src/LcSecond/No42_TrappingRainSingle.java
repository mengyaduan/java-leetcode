package LcSecond;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/?envType=daily-question&envId=2024-04-12">接雨水</a>
 **/
public class No42_TrappingRainSingle {

    /**
     * 通过单调栈来处理一下试试
     * - 先找所有非递减区间
     * - 再找所有递减区间
     * - 二者求和就行了
     **/

    public int trap(int[] height) {
        int res = 0;
        // 存坐标！！
        Deque<Integer> lowToHigh = new ArrayDeque<>();
        Deque<Integer> highToLow = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            int cur = height[i];
            if (lowToHigh.isEmpty() || cur >= height[lowToHigh.peekLast()]) {
                lowToHigh.add(i);
            }
            while (!highToLow.isEmpty() && cur >= height[highToLow.peekLast()]) {
                highToLow.pollLast();
            }
            highToLow.add(i);
        }

        int startIdx = lowToHigh.isEmpty() ? -1 : lowToHigh.pollFirst();
        while (startIdx != -1 && !lowToHigh.isEmpty()) {
            int endIdx = lowToHigh.pollFirst();
            res += clacWater(height, startIdx, endIdx);
            startIdx = endIdx;
        }

        startIdx = highToLow.isEmpty() ? -1 : highToLow.pollFirst();
        while (startIdx != -1 && !highToLow.isEmpty()) {
            int endIdx = highToLow.pollFirst();
            res += clacWater(height, startIdx, endIdx);
            startIdx = endIdx;
        }
        return res;
    }

    private int clacWater(int[] height, int startIdx, int endIdx) {
        int count = 0;
        int roof = Math.min(height[startIdx], height[endIdx]);
        for (int i = startIdx + 1; i < endIdx; i++) {
            count += roof - height[i];
        }
        return count;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] height = new int[]{3, 2, 7, 6, 8, 1, 4};
        Assert.assertEquals(trap(height), 5);
        height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assert.assertEquals(trap(height), 6);
        height = new int[]{4, 2, 0, 3, 2, 5};
        Assert.assertEquals(trap(height), 9);
        height = new int[]{5, 2, 0, 3, 2, 4};
        Assert.assertEquals(trap(height), 9);
        height = new int[]{2, 0, 2};
        Assert.assertEquals(trap(height), 2);


    }
}
