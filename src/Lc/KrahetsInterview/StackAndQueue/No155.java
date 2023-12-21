package Lc.KrahetsInterview.StackAndQueue;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/min-stack/description/">最小栈</a>
 **/
public class No155 {

}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> helper;

    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (helper.isEmpty() || val < helper.peek()) {
            helper.push(val);
        } else if (val >= helper.peek()) {
            int x = helper.peek();
            helper.push(x);
        }
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

