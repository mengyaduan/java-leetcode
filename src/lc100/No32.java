package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class No32 {
    public int longestValidParentheses(String s) {
        int result = 0;
        int[] dpTable = new int[s.length()];
        char[] c = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (c[i] == '(') {
                dpTable[i] = 0;
            } else {
                if (c[i - 1] == '(') {
                    dpTable[i] = i - 2 >= 0 ? dpTable[i - 2] + 2 : 2;
                } else {
                    if (i - 1 - dpTable[i - 1] >= 0 && c[i - 1 - dpTable[i - 1]] == '(') {
                        dpTable[i] = dpTable[i - 1] + ((i - 1 - dpTable[i - 1] - 1) >= 0 ? dpTable[i - 2 - dpTable[i - 1]] : 0) + 2;
                    }
                }
            }
            result = Math.max(dpTable[i], result);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(longestValidParentheses("()(()"), 2);
        Assert.assertEquals(longestValidParentheses("((()))())"), 8);
        Assert.assertEquals(longestValidParentheses("()(())"), 6);
        Assert.assertEquals(longestValidParentheses("(()"), 2);
        Assert.assertEquals(longestValidParentheses(""), 0);
        Assert.assertEquals(longestValidParentheses(")()())"), 4);
        Assert.assertEquals(longestValidParentheses(")(()())()))"), 8);
    }
}
