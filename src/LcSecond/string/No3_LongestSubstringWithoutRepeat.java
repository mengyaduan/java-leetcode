package LcSecond.string;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">最长无重复子串</a>
 **/
public class No3_LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int res = Integer.MIN_VALUE;
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> cAtPos = new HashMap<>();
        int i = 0, j = 1;
        cAtPos.put(s.charAt(i), 0);
        while (i < j && j < s.length()) {
            char cur = s.charAt(j);
            if (cAtPos.containsKey(cur)) {
                // 有重复
                i = Math.max(cAtPos.get(cur) + 1, i);
            }
            // 无重复
            cAtPos.put(cur, j);
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
}

