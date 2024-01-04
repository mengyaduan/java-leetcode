package Lc.KrahetsInterview.Simulation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/validate-stack-sequences/description/">验证栈序列</a>
 **/
public class No946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> helper = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            helper.push(pushed[i]);
            while (!helper.isEmpty() && popped[j] == helper.peek()) {
                helper.pop();
                j++;
            }
        }
        return helper.isEmpty();
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, true},
                {new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, false},
                {new int[]{2, 1, 0}, new int[]{1, 2, 0}, true},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] pushed, int[] popped, boolean expected) {
        boolean res = validateStackSequences(pushed, popped);
        Assert.assertEquals(res, expected);

    }

}

