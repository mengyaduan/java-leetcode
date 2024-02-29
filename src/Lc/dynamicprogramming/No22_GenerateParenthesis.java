package Lc.dynamicprogramming;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/?show=1">No22 括号生成</a>
 **/
public class No22_GenerateParenthesis {

    HashMap<Integer, ArrayList<String>> memo;

    public List<String> generateParenthesis(int n) {
        memo = new HashMap<>();
        memo.put(0, new ArrayList<>(Arrays.asList("")));
        memo.put(1, new ArrayList<>(Arrays.asList("()")));
        memo.put(2, new ArrayList<>(Arrays.asList("()()", "(())")));
        return dp(n);
    }

    public List<String> dp(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> prefix = dp(i);
            List<String> suffix = dp(n - 1 - i);
            for (int j = 0; j < prefix.size(); j++) {
                for (int k = 0; k < suffix.size(); k++) {
                    res.add("(" + prefix.get(j) + ")" + suffix.get(k));
                }
            }
        }
        memo.put(n, res);
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {3},
                {1},
                {4}
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n) {
        List<String> x = generateParenthesis(n);
        System.out.println(x);

    }


}

