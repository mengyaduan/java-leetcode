package Lc.KrahetsInterview.StackAndQueue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/decode-string/description/">字符串解码</a>
 **/
public class No394 {

    /**
     * 直接入栈，当遇到右括号的时候，可以生成一部分字符串，整体拼接后，逆转
     **/

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        // 遍历s入栈，遇到右括号就执行计算，将计算结果拼接即可
        Stack<Character> stack = new Stack<>();
        for (char item : s.toCharArray()) {
            if (item == ']') {
                // 咔咔计算
                String part = decoding(stack);
                for (char i : part.toCharArray()) {
                    stack.push(i);
                }
            } else {
                stack.push(item);
            }
        }
        // 出栈就是结果
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    private String decoding(Stack<Character> stack) {
        String part = "";
        while (stack.peek() != '[') {
            char head = stack.pop();
            part = head + part;
        }
        // 弹出[
        stack.pop();
        // 弹出所有连续的数字
        String nStr = "";
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
            nStr = stack.pop() + nStr;
        }
        int n = Integer.parseInt(nStr);
        StringBuilder sb = new StringBuilder(part.length() * n);
        for (int i = 0; i < n; i++) {
            sb.append(part);
        }
        return sb.toString();
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {"3[ab]", "ababab"},
                {"3[ab]2[c]", "abababcc"},
                {"3[a2[bc]d]", "abcbcdabcbcdabcbcd"},
                {"13[ab]", "ababababababababababababab"},
                {"2[abc]3[cd]ef", "abcabccdcdcdef"},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String expected) {
        String res = decodeString(s);
        Assert.assertEquals(res, expected);

    }

}

