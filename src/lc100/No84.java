package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class No84 {

    public int largestRectangleArea(int[] heights) {
        // 从左到右，找到左边第一个小于自己的坐标，如果越界，使用-1
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> helper = new Stack<>();
        left[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int prev = i - 1;
            while (prev >= 0 && heights[i] <= heights[prev]) {
                prev = left[prev];
            }
            if (prev < 0) {
                left[i] = -1;
            } else {
                left[i] = prev;
            }
        }
        right[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int suffix = i + 1;
            while (suffix < heights.length && heights[i] <= heights[suffix]) {
                suffix = right[suffix];
            }
            if (suffix >= heights.length) {
                right[i] = heights.length;
            } else {
                right[i] = suffix;
            }
        }
        int result = 0;
        for (int i = 0; i < left.length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }

    public int largestRectangleAreaAns(int[] heights) {
        // 从左到右，找到左边第一个小于自己的坐标，如果越界，使用-1
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> helper = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int leftBound = i - 1;
            while (true) {
                if (helper.isEmpty() || heights[i] > heights[helper.peek()]) {
                    left[i] = helper.isEmpty() ? -1 : leftBound;
                    helper.push(i);
                    break;
                } else {
                    // 如果栈顶大于等于当前值，弹出
                    leftBound = left[helper.pop()];
                }
            }
        }
        helper.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            int rightBound = i + 1;
            while (true) {
                if (helper.isEmpty() || heights[i] > heights[helper.peek()]) {
                    right[i] = helper.isEmpty() ? heights.length : rightBound;
                    helper.push(i);
                    break;
                } else {
                    // 如果栈顶大于等于当前值，弹出
                    rightBound = right[helper.pop()];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < left.length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0}), 20);
        Assert.assertEquals(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}), 10);
        Assert.assertEquals(largestRectangleArea(new int[]{1, 2, 3, 4, 5}), 9);
        Assert.assertEquals(largestRectangleArea(new int[]{2, 4}), 4);

    }
}
