package Lc.KrahetsInterview.StackAndQueue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/valid-parentheses/description/">括号配对</a>
 **/
public class No20 {

    /**
     * 遍历入栈，如果有右括号，栈顶必须能弹出，否则必不对
     **/

    public boolean isValid(String s) {
        HashMap<Character, Character> pa = new HashMap<>();
        pa.put('(', ')');
        pa.put('[', ']');
        pa.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char item : s.toCharArray()) {
            if (item == '(' || item == '[' || item == '{') {
                stack.push(item);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char head = stack.pop();
            if (pa.get(head) != item) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {"()", true},
                {"()[]{}", true},
                {"(}", false},
                {"}", false},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, boolean expected) {
        boolean res = isValid(s);
        Assert.assertEquals(res, expected);

    }

}

