package LC100Again;


import org.testng.annotations.Test;

import java.util.Stack;

public class Lc071 {

    public String decodeString(String s) {

        StringBuilder result = new StringBuilder();
        Stack<Character> helper = new Stack<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != ']') {
                helper.push(sc[i]);
            } else {
                updateHelper(helper);
            }
        }
        while (!helper.isEmpty()) {
            result.append(helper.pop());
        }
        return result.reverse().toString();
    }

    private void updateHelper(Stack<Character> helper) {
        StringBuilder sb = new StringBuilder();
        // 开始弹出数据，直到遇到第一个[
        while (!helper.isEmpty() && helper.peek() != '[') {
            sb.append(helper.pop());
        }
        if (helper.isEmpty()) {
            // 实际这里应该用不上
            return;
        }
        // 弹出[
        helper.pop();
        // 组装前置数字
        int num = 0;
        int base = 1;
        while (!helper.isEmpty() && (helper.peek() >= '0' && helper.peek() <= '9')) {
            num += base * (helper.pop() - '0');
            base *= 10;
        }
        // 压回helper
        String item = sb.reverse().toString();
        for (int i = 0; i < num; i++) {
            for (char c : item.toCharArray()) {
                helper.push(c);
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(decodeString("2[ab4[m]c]3[cd]ef"));
        System.out.println(decodeString("3[a]2[bc]"));

    }


}
