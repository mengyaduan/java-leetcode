package LC100Again;


import org.testng.annotations.Test;

public class Lc090 {

    public int longestValidParentheses(String s) {
        char[] sc = s.toCharArray();
        int result = 0;
        // 只有)才会赋值
        int[] dpTable = new int[sc.length];
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(') {
                continue;
            }
            int lastIdx = -1;
            if (i > 0 && sc[i - 1] == ')') {
                // 如果前一个是右括号
                // 前一个右括号有值 且 减掉该值后是个左括号，此时才可以更新
                if (dpTable[i - 1] > 0 && i - dpTable[i - 1] - 1 >= 0 && sc[i - dpTable[i - 1] - 1] == '(') {
                    dpTable[i] = dpTable[i - 1] + 2;
                    lastIdx = i - dpTable[i - 1] - 2;
                }
            } else if (i > 0 && sc[i - 1] == '(') {
                // 如果前一个是左括号
                // 自动组成一对，同时检查再往前一个是否存在，如果存在则合并
                dpTable[i] = 2;
                lastIdx = i - 2;
            }
            if (lastIdx >= 0 && dpTable[lastIdx] > 0) {
                dpTable[i] += dpTable[lastIdx];
            }
            result = Math.max(dpTable[i], result);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestValidParentheses("()())"));
        System.out.println(longestValidParentheses("()()()"));
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(())"));

    }

}
