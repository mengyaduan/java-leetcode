package LcSpring100;

import org.testng.annotations.Test;

import java.util.Stack;

public class No402RemoveKdigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> helper = new Stack<>();
        int count = 0;
        for (char item : num.toCharArray()) {
            while (!helper.isEmpty() && helper.peek() > item && count < k) {
                helper.pop();
                count++;
            }
            helper.add(item);
        }
        while (count < k && !helper.isEmpty()) {
            helper.pop();
            count++;
        }
        StringBuilder sb = new StringBuilder();
        while (!helper.isEmpty()) {
            sb = sb.append(helper.pop());
        }
        String result = sb.reverse().toString();
        int idx = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0') {
                idx++;
            } else {
                break;
            }
        }
        return idx == result.length() ? "0" : result.substring(idx);
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("142628219", 4));
        System.out.println(removeKdigits("142628219", 5));
        System.out.println(removeKdigits("142628219", 6));
        System.out.println(removeKdigits("142628219", 7));
        System.out.println(removeKdigits("142628219", 9));

    }
}
