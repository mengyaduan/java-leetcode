package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LCR085 {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(n, 0, new StringBuilder());
        return result;
    }

    private void backtrack(int leftCnt, int rightCnt, StringBuilder stringBuilder) {
        if (leftCnt == 0 && rightCnt == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        if (leftCnt > 0) {
            // 加个左括号
            stringBuilder.append('(');
            backtrack(leftCnt - 1, rightCnt + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (rightCnt > 0) {
            // 加个右括号
            stringBuilder.append(')');
            backtrack(leftCnt, rightCnt - 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }


    }

    @Test(description = "")
    public void test() throws Exception {
        List<String> x = generateParenthesis(3);
        System.out.println(x);

    }


}
