package LcSecond.dynamicprogram;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/word-break/description/">单词拆分</a>
 */
public class No139_WordBreak {

    int[][] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1][s.length() + 1];
        return dp(s, wordDict, 0, 1);
    }

    public boolean dp(String s, List<String> wordDict, int start, int end) {
        if (start == s.length()) {
            return true;
        }
        if (end > s.length()) {
            return false;
        }
        if (memo[start][end] != 0) {
            return memo[start][end] == 1;
        }
        boolean res = false;
        String word = s.substring(start, end);
        if (wordDict.contains(word)) {
            res = dp(s, wordDict, end, end + 1) || dp(s, wordDict, start, end + 1);
        } else {
            res = dp(s, wordDict, start, end + 1);
        }
        memo[start][end] = res ? 1 : 2;
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
//                {"leetcode", new ArrayList<>(Arrays.asList("leet", "code")), true},
//                {"applepenapple", new ArrayList<>(Arrays.asList("apple", "pen")), true},
//                {"catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat")), false},
//                {"aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aaa")), true},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")), false},

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, ArrayList<String> dict, boolean expected) {
        boolean xx = wordBreak(s, dict);
        Assert.assertEquals(xx, expected);
    }
}
