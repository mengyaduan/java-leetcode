package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No139 {

    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1];
        return dp(s.toCharArray(), 0, wordDict);
    }

    public boolean dp(char[] cs, int idx, List<String> words) {
        if (idx == cs.length) {
            return true;
        }
        if (memo[idx] != 0) {
            return memo[idx] == 1;
        }
        ArrayList<String> matchedWord = new ArrayList<>();
        for (String word : words) {
            char[] w = word.toCharArray();
            boolean match = true;
            for (int i = 0; i < w.length; i++) {
                if (idx + i >= cs.length || cs[idx + i] != w[i]) {
                    // 越界或者不等，都不匹配
                    match = false;
                    break;
                }
            }
            if (match) {
                matchedWord.add(word);
            }
        }
        boolean result = false;
        for (String word : matchedWord) {
            result |= dp(cs, idx + word.length(), words);
            if (result) {
                memo[idx] = 1;
                return result;
            }
        }
        memo[idx] = 2;
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertTrue(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        Assert.assertFalse(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));

    }
}
