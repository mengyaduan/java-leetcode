package LcSpring100;

import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Base64;
import java.util.Deque;
import java.util.Stack;

public class No85MaxRectangle {

    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        // TO_YAMENG 2025/2/28 不会，看答案
        int m = matrix.length;
        int n = matrix[0].length;
        // 遍历每一行，得到以每行为底边的矩形的高低，然后用No84的方式求最大矩形即可
        int[][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : (1 + heights[i - 1][j]);
                }
            }
        }
        // 对每一行求最值
        for (int i = 0; i < m; i++) {
            result = Math.max(result, getMaximalRec(heights[i]));
        }

        return result;
    }

    public int getMaximalRec(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> helper = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!helper.isEmpty() && height[helper.peek()] >= height[i]) {
                helper.pop();
            }
            if (helper.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = helper.peek();
            }
            helper.add(i);
        }
        helper.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!helper.isEmpty() && height[helper.peek()] >= height[i]) {
                helper.pop();
            }
            if (helper.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = helper.peek();
            }
            helper.add(i);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max((right[i] - left[i] - 1) * height[i], result);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));

    }


}
