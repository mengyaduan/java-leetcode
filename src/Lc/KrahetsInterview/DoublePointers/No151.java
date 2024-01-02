package Lc.KrahetsInterview.DoublePointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">翻转字符串</a>
 **/
public class No151 {

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String word = "";
        for (Character item : s.toCharArray()) {
            if (item == ' ') {
                if (!word.isEmpty()) {
                    stack.push(word);
                }
                word = "";
            } else {
                word += item;
            }
        }
        if (!word.isEmpty()) {
            stack.push(word);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop()).append(" ");
        }
        return res.substring(0, res.length() - 1);
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"  hello world  ", "world hello"},
                {"a good   example", "example good a"},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String expected) {
        String res = reverseWords(s);
        Assert.assertEquals(res, expected);

    }

}

