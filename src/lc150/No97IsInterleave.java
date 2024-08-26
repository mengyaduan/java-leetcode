package lc150;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/interleaving-string/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No97IsInterleave {

    HashMap<String, Boolean> helper;

    public boolean isInterleave(String s1, String s2, String s3) {
        helper = new HashMap<>();
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        return dp(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0) ||
                dp(s2.toCharArray(), 0, s1.toCharArray(), 0, s3.toCharArray(), 0);
    }

    public boolean dp(char[] s1, int i, char[] s2, int j, char[] s3, int k) {
        if (k >= s3.length) {
            return true;
        }
        if (i >= s1.length) {
            return new String(s2).substring(j).equals(new String(s3).substring(k));
        }
        if (j >= s2.length && s3[k] != s1[i]) {
            return new String(s1).substring(i).equals(new String(s3).substring(k));
        }

        String key = new String(s1).substring(i) + "_" + new String(s2).substring(j) + "_" + k;
        if (helper.containsKey(key)) {
            return helper.get(key);
        }

        boolean res = false;
        if (s1[i] == s3[k]) {
            // 如果相同，则继续向前 或者 变更顺序
            res = dp(s1, i + 1, s2, j, s3, k + 1) || dp(s2, j, s1, i + 1, s3, k + 1);
            if (res) {
//                helper.put(key, res);
                return res;
            }
        }
        helper.put(key, res);
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(isInterleave("ab", "12", "a1b2"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));

    }
}
