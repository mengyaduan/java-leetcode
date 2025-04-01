package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static DataStruct.tools.printIntArray;

public class LCR039 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        // 从左到右，维持一个升序的队列，队列里面先存坐标，然后计算
        Deque<Integer> helper = new ArrayDeque<>();
        helper.addLast(-1);
        for (int i = 0; i < n; i++) {
            int top = helper.peekLast() == -1 ? Integer.MIN_VALUE : heights[helper.peekLast()];
            if (heights[i] <= top) {
                while (helper.peekLast() != -1 && heights[helper.peekLast()] >= heights[i]) {
                    helper.pollLast();
                }
            }
            l2r[i] = heights[i] * (i - helper.peekLast());
            helper.addLast(i);
        }
        helper.clear();
        helper.addLast(n);
        for (int i = n - 1; i >= 0; i--) {
            int top = helper.peekLast() == n ? Integer.MIN_VALUE : heights[helper.peekLast()];
            if (heights[i] <= top) {
                while (helper.peekLast() != n && heights[helper.peekLast()] >= heights[i]) {
                    helper.pollLast();
                }
            }
            r2l[i] = heights[i] * (helper.peekLast() - i);
            helper.addLast(i);
        }
        int result = 0;
        for (int i = 0; i < l2r.length; i++) {
            int sum = l2r[i] + r2l[i] - heights[i];
            result = Math.max(result, sum);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(largestRectangleArea(new int[]{999, 999, 999, 999}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{4, 2}));
        System.out.println(largestRectangleArea(new int[]{4}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(largestRectangleArea(new int[]{1, 2, 3, 4, 5}));

    }

}
