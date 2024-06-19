package lc75;

import org.testng.annotations.Test;

import java.util.Stack;


/**
 * @see <a href="https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75">字符串解码</a>
 */
public class No394_decodeString {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> helper = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (!helper.isEmpty() && s.charAt(i) == ']') {
                processStack(helper);
            } else {
                helper.push(s.charAt(i));
            }
            i++;
        }
        while (!helper.isEmpty()) {
            res.insert(0, helper.pop());
        }
        return res.toString();
    }

    private void processStack(Stack<Character> helper) {
        StringBuilder item = new StringBuilder();
        while (!helper.isEmpty() && helper.peek() != '[') {
            // 保持弹出，一直到第一个'['
            item.insert(0, helper.pop() + "");
        }
        // 弹出'['
        helper.pop();
        // 弹出所有数字
        int count = 0;
        int flag = 1;
        while (!helper.isEmpty() && isNumber(helper.peek())) {
            count += (helper.pop() - '0') * flag;
            flag *= 10;
        }
        // 将item重复count次，压入栈
        for (int i = 0; i < count; i++) {
            for (Character c : item.toString().toCharArray()) {
                helper.push(c);
            }
        }
    }

    private boolean isNumber(Character c) {
        return c >= '0' && c - '0' < 10;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]2[cd]ef"));
        System.out.println(decodeString("abcd"));

    }


}