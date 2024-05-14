package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/description/">生成括号</a>
 */
public class No22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> base = new ArrayList<>(Arrays.asList("()"));
        if (n == 1) {
            return base;
        }
        for (int i = 2; i < n + 1; i++) {
            base = createParenthesis(base);
        }
        return base;
    }

    private ArrayList<String> createParenthesis(ArrayList<String> base) {
        HashSet<String> memo = new HashSet<>();
        String ins = "()";
        for (String s : base) {
            // 对每一个结果的每个位置，加一个()
            for (int i = 0; i <= s.length(); i++) {
                memo.add(s.substring(0, i) + ins + s.substring(i));
            }
        }
        return new ArrayList<>(memo);
    }

    @Test(description = "")
    public void test() throws Exception {
        ArrayList<String> base = new ArrayList<>(Arrays.asList("()"));
        System.out.println(generateParenthesis(3));


    }
}
