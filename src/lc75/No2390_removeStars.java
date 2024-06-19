package lc75;


import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75">移除字符串中的星号</a>
 */
public class No2390_removeStars {

    public String removeStars(String s) {
        Stack<Character> helper = new Stack<>();
        for (char item : s.toCharArray()) {
            if (item == '*' && !helper.isEmpty()) {
                helper.pop();
            } else {
                helper.add(item);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!helper.isEmpty()) {
            sb.append(helper.pop());
        }
        return sb.reverse().toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));

    }
}
