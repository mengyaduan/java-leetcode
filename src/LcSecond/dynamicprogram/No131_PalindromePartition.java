package LcSecond.dynamicprogram;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-partitioning/description/">分割回文串</a>
 */
public class No131_PalindromePartition {

    List<List<String>> result;
    boolean[][] memo;

    public List<List<String>> partition(String s) {
        memo = new boolean[s.length()][s.length()];
        int maxLen = 1;
        // 将回文串标记好，这里循环的idx有讲究，正常i,j的话会错
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                memo[i][i] = true;
                if (s.charAt(i) == s.charAt(j) && ((j - i) <= 2 || memo[i + 1][j - 1])) {
                    maxLen = Math.max(maxLen, j - i + 1);
                    memo[i][j] = true;
                } else {
                    memo[i][j] = false;
                }
            }
        }
        // 回溯
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int start, List<String> path) {
        // 这里需要分开处理，xxxxaba和xxxxabc 的场景
        if (start == s.length() - 1) {
            ArrayList<String> tmp = new ArrayList<>(path);
            tmp.add(s.charAt(start) + "");
            result.add(tmp);
            return;
        }
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (memo[start][i]) {
                // 如果是回文，则可以加入
                path.add(s.substring(start, i + 1));
                backtrack(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        List<List<String>> x = partition("aaabcacba");
        for (List<String> item : x) {
            System.out.println(StringUtils.join(item, ","));
        }
    }
}
