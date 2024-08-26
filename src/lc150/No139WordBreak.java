package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No139WordBreak {
    int[][] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1][s.length() + 1];
        return dp(s, 0, 1, wordDict);
    }

    public boolean dp(String s, int start, int end, List<String> wordDict) {
        if (start >= s.length()) {
            return true;
        }
        if (end > s.length()) {
            return false;
        }
        if (memo[start][end] > 0) {
            return memo[start][end] == 1;
        }
        String subStr = s.substring(start, end);
        boolean res = false;
        if (wordDict.contains(subStr)) {
            res = dp(s, end, end + 1, wordDict) || dp(s, start, end + 1, wordDict);
        } else {
            res = dp(s, start, end + 1, wordDict);
        }
        memo[start][end] = res ? 1 : 2;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
        System.out.println(wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));

    }
}
