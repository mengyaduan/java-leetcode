package lc150;

import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No150EvalRPN {

    public int evalRPN(String[] tokens) {

        Stack<Integer> helper = new Stack<>();
        int res = 0;
        for (String item : tokens) {
            if ("+-*/".contains(item)) {
                int a = helper.pop();
                int b = helper.pop();
                switch (item) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = b - a;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = b / a;
                        break;
                }
            } else {
                res = Integer.parseInt(item);
            }
            helper.push(res);
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));


    }

}
