package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc059 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int leftUsed, int rightNotUsed, StringBuilder path, List<String> result) {
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }
        //  可以添加左括号
        if (leftUsed < n) {
            path.append('(');
            backtrack(n, leftUsed + 1, rightNotUsed + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
        // 可以添加右括号
        if (rightNotUsed > 0) {
            path.append(')');
            backtrack(n, leftUsed, rightNotUsed - 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));

    }

}



