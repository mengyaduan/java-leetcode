package Lc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No22GenerateParenthesis {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtrack(n, 0, new StringBuilder());

        return result;
    }

    /**
     * @param left  可以追加的左括号的数量
     * @param right 可以追加的右括号的数量
     * @param path
     */
    public void backtrack(int left, int right, StringBuilder path) {
        if (left == 0 && right == 0) {
            result.add(path.toString());
        }

        if (left > 0) {
            path.append('(');
            backtrack(left - 1, right + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0) {
            path.append(')');
            backtrack(left, right - 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(3));


    }
}
