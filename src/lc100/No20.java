package lc100;

import java.util.Stack;

public class No20 {

    public boolean isValid(String s) {
        Stack<Character> helper = new Stack<>();
        for (Character item : s.toCharArray()) {
            if (item == '(' || item == '{' || item == '[') {
                // 左括号直接扔进队列
                helper.push(item);
            } else {
                // 如果是右括号，则需要成对弹出
                if (helper.isEmpty()) {
                    return false;
                }
                char peek = helper.pop();
                boolean res = item == ')' && peek == '(';
                res |= item == ']' && peek == '[';
                res |= item == '}' && peek == '{';
                if (!res) {
                    // 没有成对出现，一定不符合
                    return res;
                }
            }
        }
        return helper.isEmpty();
    }
}
