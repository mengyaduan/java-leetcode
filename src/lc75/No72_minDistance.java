package lc75;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=leetcode-75">编辑距离</a>
 */
public class No72_minDistance {

    HashMap<String, Integer> helper;

    public int minDistance(String word1, String word2) {
        helper = new HashMap<>();
        return dp(word1, word2);
    }

    public int dp(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return s1.isEmpty() ? s2.length() : s1.length();
        }
        String key = s1 + "_" + s2;
        if (helper.containsKey(key)) {
            return helper.get(key);
        }
        int res = Integer.MAX_VALUE;
        if (s1.charAt(0) == s2.charAt(0)) {
            res = Math.min(res, dp(s1.substring(1), s2.substring(1)));
        } else {
            int delete = dp(s1.substring(1), s2);
            int changeFirst = dp(s1.substring(1), s2.substring(1));
            int insertFirst = dp(s1, s2.substring(1));
            res = Math.min(delete + 1, res);
            res = Math.min(changeFirst + 1, res);
            res = Math.min(insertFirst + 1, res);
        }
        helper.put(key, res);
        return helper.get(key);
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minDistance("ab", "a"));
//        System.out.println(minDistance("horse", "ros"));
//        System.out.println(minDistance("intention", "execution"));
//        System.out.println(minDistance("", "a"));

    }
}
