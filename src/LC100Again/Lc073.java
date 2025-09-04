package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc073 {

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Deque<Integer> helper = new ArrayDeque<>();
        helper.offerLast(-1);
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? -1 : heights[i];
            while (helper.size() > 1 && heights[helper.peekLast()] >= h) {
                int curH = heights[helper.pollLast()];
                result = Math.max(curH * (i - helper.peekLast() - 1), result);
            }
            helper.offerLast(i);
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 6, 5, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{2, 4}));

    }

}
