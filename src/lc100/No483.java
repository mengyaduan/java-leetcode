package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No483 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] memo = new int[26];
        for (char c : p.toCharArray()) {
            memo[c - 'a'] += 1;
        }
        char[] sc = s.toCharArray();
        int maxSize = p.length();

        int[] helper = new int[26];
        int left = 0;
        int right = 0;
        while (left < s.length() && right <= s.length()) {
            // 如果当前窗口满足，则追加答案，缩小左边界
            if (right - left == maxSize) {
                result.add(left);
                helper[sc[left] - 'a'] -= 1;
                left += 1;
                continue;
            }
            // 如果已经抵达右边界，则直接break
            if (right == s.length()) {
                break;
            }
            // 否则扩展右边界
            int idx = sc[right] - 'a';
            helper[idx] += 1;
            right++;
            // 情况1：当前字母不在p内，此时需要将左边界直接归零
            if (memo[idx] == 0) {
                left = right;
                Arrays.fill(helper, 0);
            } else if (helper[idx] > memo[idx]) {
                // 情况2：当前字母在p内，但是出现的频率高于目标，需要缩左边界到首次出现该字母
                for (int i = left; i < right; i++) {
                    // 弹出收缩的字母
                    helper[sc[i] - 'a'] -= 1;
                    if (sc[i] - 'a' == idx) {
                        left = i + 1;
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));

    }
}
