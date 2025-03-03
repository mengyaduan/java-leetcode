package LcSpring100;

import org.testng.annotations.Test;

import java.util.Stack;

public class No84LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 对于height[i]：左侧第一个小于它的坐标，默认为-1
        int[] leftLt = new int[n];
        // 对于height[i]：右侧第一个小于它的坐标，默认为len
        int[] rightLt = new int[n];
        // 通过单调栈，来分别给leftLt和rightLt赋值
        Stack<Integer> idx = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 如果栈里面非空，则比较栈顶，如果大于栈顶，可以入栈；否则持续弹出直到可以入栈
            while (!idx.isEmpty() && heights[idx.peek()] >= heights[i]) {
                idx.pop();
            }
            if (idx.isEmpty()) {
                leftLt[i] = -1;
            } else {
                leftLt[i] = idx.peek();
            }
            idx.push(i);
        }
        idx.clear();
        // 从右向左找
        for (int i = n - 1; i >= 0; i--) {
            // 如果栈里面非空，则比较栈顶，如果大于栈顶，可以入栈；否则持续弹出直到可以入栈
            while (!idx.isEmpty() && heights[idx.peek()] >= heights[i]) {
                idx.pop();
            }
            if (idx.isEmpty()) {
                rightLt[i] = n;
            } else {
                rightLt[i] = idx.peek();
            }
            idx.push(i);
        }
        // 结算结果
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, (rightLt[i] - leftLt[i] - 1) * heights[i]);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));

    }

}
