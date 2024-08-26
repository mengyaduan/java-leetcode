package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No22GenerateParenthesis {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n, 0, new StringBuilder());
        return res;
    }

    /**
     * @param n             可以添加的左括号数量
     * @param right         可以添加的右括号数量
     * @param stringBuilder
     */
    private void backtrack(int n, int right, StringBuilder stringBuilder) {
        if (n == 0 && right == 0) {
            res.add(stringBuilder.toString());
            return;
        }

        if (n > 0) {
            stringBuilder.append('(');
            backtrack(n - 1, right + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (right > 0) {
            stringBuilder.append(')');
            backtrack(n, right - 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }

}
