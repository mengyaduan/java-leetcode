package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class No394 {


    public String decodeString(String s) {
        Stack<Character> helper = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                // decode
                decodeOnce(helper);
            } else {
                helper.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!helper.isEmpty()) {
            sb.append(helper.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 将helper栈顶的 [ 解码
     *
     * @param helper
     */
    private void decodeOnce(Stack<Character> helper) {
        StringBuilder sb = new StringBuilder();
        while (!helper.isEmpty() && helper.peek() != '[') {
            sb.append(helper.pop());
        }
        int number = 0;
        helper.pop();
        int flag = 1;
        while (!helper.isEmpty() && helper.peek() >= '0' && helper.peek() <= '9') {
            number += (helper.pop() - '0') * flag;
            flag *= 10;
        }
        char[] word = sb.reverse().toString().toCharArray();
        for (int i = 0; i < number; i++) {
            for (char c : word) {
                helper.push(c);
            }
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals((decodeString("2[abc]3[cd]ef")), "abcabccdcdcdef");
        Assert.assertEquals((decodeString("3[a2[c]]")), "accaccacc");

    }
}
