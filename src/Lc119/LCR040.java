package Lc119;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.zip.CheckedInputStream;

public class LCR040 {

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int m = matrix.length, n = matrix[0].length();
        int[][] h = new int[m][n];
        for (int i = 0; i < m; i++) {
            char[] row = matrix[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int item = row[j] - '0';
                if (i == 0) {
                    h[i][j] = item;
                } else {
                    h[i][j] = item == 0 ? 0 : (item + h[i - 1][j]);
                }
            }
        }
        for (int[] row : h) {
            result = Math.max(result, largestRectangleArea(row));
        }
        return result;
    }

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

}
