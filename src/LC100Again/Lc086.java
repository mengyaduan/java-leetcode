package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Lc086 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dp(s, 0, wordDict, memo);
    }

    private boolean dp(String s, int start, List<String> wordDict, int[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != -1) {
            return memo[start] == 1;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String prefix = s.substring(start, i);
            if (wordDict.contains(prefix)) {
                boolean result = dp(s, i, wordDict, memo);
                if (result) {
                    memo[start] = 1;
                    return true;
                }
            }
        }
        memo[start] = 2;
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));


    }


}
