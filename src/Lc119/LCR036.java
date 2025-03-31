package Lc119;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCR036 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> helper = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                //触发计算
                int top1 = helper.pollLast();
                int top2 = helper.pollLast();
                helper.addLast(compute(top2, top1, token));
            } else {
                helper.addLast(Integer.parseInt(token));
            }
        }
        return helper.pollLast();
    }

    private Integer compute(int top2, int top1, String token) {
        if (token.equals("+")) {
            return top2 + top1;
        } else if (token.equals("-")) {
            return top2 - top1;
        } else if (token.equals("*")) {
            return top2 * top1;
        } else {
            return top2 / top1;
        }
    }

}
