package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No32OverLimit {
    int[][] memo;
    int result;

    public int longestValidParentheses(String s) {
        result = 0;
        memo = new int[s.length() + 1][s.length() + 1];
        boolean flag = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                memo[i - 1][i] = 1;
                flag = true;
            }
        }
        while (flag) {
            flag = false;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    boolean hasMerged = false;
                    if (memo[i][j] == 1) {
                        result = Math.max(result, j - i + 1);
                        int left = i, right = j;
                        // 场景一，两侧用()包住，此时可以延长
                        while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == '(' && s.charAt(right + 1) == ')') {
                            left--;
                            right++;
                        }
                        if (left < i || right > j) {
                            hasMerged = true;
                        }
                        memo[left][right] = 1;
                        result = Math.max(result, right - left - 1);
                        // 场景二，左侧有 memo[x][i-1] = 1是合规的，可以直接拼接
                        if (i - 1 >= 0) {
                            for (int k = 0; k < i - 1; k++) {
                                if (memo[k][i - 1] == 1) {
                                    memo[k][i - 1] = 0;
                                    left = k;
                                    break;
                                }
                            }
                        }
                        // 场景三，右侧有memo[j+1][y]=1是合规的，继续拼接
                        if (j + 1 < s.length()) {
                            for (int k = s.length() - 1; k > j + 1; k--) {
                                if (memo[j + 1][k] == 1) {
                                    memo[j + 1][k] = 0;
                                    right = k;
                                    break;
                                }
                            }
                        }
                        // 合并场景二、三的结果
                        memo[left][right] = 1;
                        result = Math.max(result, right - left + 1);
                        if (left < i || right > j) {
                            // 如果memo[i][j]参与到了任一的合并，那么应该将i,j表示擦除，避免重复处理
                            hasMerged = true;
                        }
                        if (hasMerged) {
                            // 本轮有更新，则将i,j归零
                            memo[i][j] = 0;
                        }
                        // 任一一轮中有更新，最终都要重新循环
                        flag |= hasMerged;
                    }
                }
            }

        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(longestValidParentheses("((()))())"), 8);
        Assert.assertEquals(longestValidParentheses("()(())"), 6);
        Assert.assertEquals(longestValidParentheses("(()"), 2);
        Assert.assertEquals(longestValidParentheses(""), 0);
        Assert.assertEquals(longestValidParentheses(")()())"), 4);
        Assert.assertEquals(longestValidParentheses(")(()())()))"), 8);
    }

}
