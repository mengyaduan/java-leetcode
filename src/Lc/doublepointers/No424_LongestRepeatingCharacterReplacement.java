package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/longest-repeating-character-replacement/description/">替换后的最长重复字符</a>
 **/
public class No424_LongestRepeatingCharacterReplacement {
    /**
     * 滑动窗口，遍历字符串s，一个变量存subString，另外维护一个map，存储各自出现的频率，每次窗口移动时，需要在窗口内选择频率最高的
     **/
    public int characterReplacement(String s, int k) {
        if (s.length() <= k + 1) {
            return s.length();
        }
        int maxRes = Integer.MIN_VALUE;
        HashMap<Character, Integer> helper = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 确定替换的char，遍历到最大值
            char target = s.charAt(i);
            int leftTimes = k;
            int right = i + 1;
            while (leftTimes >= 0 && right < s.length()) {
                if (s.charAt(right) == target) {
                    right++;
                } else {
                    if (leftTimes > 0) {
                        leftTimes--;
                        right++;
                    } else {
                        leftTimes--;
                    }
                }
                maxRes = Math.max(maxRes, right - i);
            }
            if (right == s.length() && leftTimes > 0) {
                maxRes = Math.max(maxRes, Math.min(right - i + leftTimes, s.length()));
            }
        }
        return maxRes;
    }

    public int characterReplacementAns(String s, int k) {
        int[] helper = new int[26];
        int left = 0;
        int maxSame = 0;
        int windowSize = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            helper[c] += 1;
            maxSame = Math.max(maxSame, helper[c]);
            windowSize = i - left + 1;
            if (windowSize > maxSame + k) {
                helper[s.charAt(left) - 'A'] -= 1;
                left++;
            }
        }
        return s.length() - left;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(characterReplacementAns("ABCDDD", 3), 6);
    }
}

