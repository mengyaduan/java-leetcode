package LcSpring100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class No394DecodeString {

    public String decodeString(String s) {
        Stack<Character> helper = new Stack<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char item = cs[i];
            if (item != ']') {
                // 只要不是后括号，就直接追加
                helper.add(item);
            } else {
                StringBuilder segment = new StringBuilder();
                // 如果是后括号，说明此时需要弹出处理了
                while (!helper.isEmpty() && helper.peek() != '[') {
                    segment.append(helper.pop());
                }
                // 弹出 [
                helper.pop();
                // 获取数字
                int number = 0;
                int carry = 1;
                while (!helper.isEmpty() && (helper.peek() >= '0' && helper.peek() <= '9')) {
                    number += (helper.pop() - '0') * carry;
                    carry *= 10;
                }
                // 获取本轮数据，并录入到helper中
                for (int j = 0; j < number; j++) {
                    for (int k = segment.length() - 1; k >= 0; k--) {
                        helper.push(segment.charAt(k));
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!helper.isEmpty()) {
            stringBuilder.append(helper.pop());
        }
        return stringBuilder.reverse().toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(decodeString("3[a2[c]]"), "accaccacc");

    }
}
