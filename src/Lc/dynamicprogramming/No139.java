package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/word-break/?show=1">No139 单词划分</a>
 **/
public class No139 {

    boolean res = false;
    int[][] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        res = false;
        memo = new int[s.length() + 1][s.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, 1, wordDict);
    }

    public boolean dp(String s, int i, int j, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        if (j > s.length()) {
            return false;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        String word = s.substring(i, j);
        if (wordDict.contains(word)) {
            res = dp(s, j, j + 1, wordDict) || dp(s, i, j + 1, wordDict);
        } else {
            res = dp(s, i, j + 1, wordDict);
        }
        memo[i][j] = res ? 1 : 0;
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"leetcode", new ArrayList<>(Arrays.asList("leet", "code")), true},
                {"applepenapple", new ArrayList<>(Arrays.asList("apple", "pen")), true},
                {"catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat")), false},
                {"aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aaa")), true},

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, ArrayList<String> dict, boolean expected) {
        boolean xx = wordBreak(s, dict);
        Assert.assertEquals(xx, expected);
    }
}
