package lc150;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> helper;

    public MinStack() {
        minStack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        if (helper.isEmpty() || val < helper.peek()) {
            helper.push(val);
        } else {
            helper.push(helper.peek());
        }
        minStack.push(val);
    }

    public void pop() {
        minStack.pop();
        helper.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return helper.peek();
    }

}
