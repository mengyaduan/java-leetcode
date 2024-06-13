package lc75;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75">反转字符串中的单词</a>
 */
public class No151_ReverseWords {
    public String reverseWords(String s) {
        int cur = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (cur >= 0) {
            while (cur >= 0 && s.charAt(cur) == ' ') {
                cur--;
            }
            String item = "";
            while (cur >= 0 && s.charAt(cur) != ' ') {
                item = s.charAt(cur) + item;
                cur--;
            }
            if (!item.isEmpty()) {
                if (sb.toString().equals("")) {
                    sb.append(item);
                } else {
                    sb.append(" " + item);
                }
            }
        }
        return sb.toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(reverseWords("the 3sky is   blue   "));

    }
}
