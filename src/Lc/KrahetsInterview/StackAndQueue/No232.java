package Lc.KrahetsInterview.StackAndQueue;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/description/">用栈实现队列</a>
 **/
public class No232 {

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}

class MyQueue {
    Stack<Integer> helper;
    Stack<Integer> myQ;

    public MyQueue() {
        myQ = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        if (myQ.isEmpty()) {
            myQ.push(x);
        } else {
            while (!myQ.isEmpty()) {
                helper.push(myQ.pop());
            }
            myQ.push(x);
            while (!helper.isEmpty()) {
                myQ.push(helper.pop());
            }
        }
    }

    public int pop() {
        return myQ.pop();
    }

    public int peek() {
        return myQ.peek();

    }

    public boolean empty() {
        return myQ.isEmpty();
    }
}

