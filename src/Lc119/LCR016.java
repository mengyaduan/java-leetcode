package Lc119;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class LCR016 {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] sc = s.toCharArray();
        int[] letter = new int[128];
        Arrays.fill(letter, -1);
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int idx = sc[right];
            if (letter[idx] != -1) {
                // 字符已经出现过了，则需要将窗口缩小到上次出现的位置以后，将删除的所有字符归为-1
                int newLeft = letter[idx] + 1;
                for (int i = left; i <= letter[idx]; i++) {
                    letter[sc[i]] = -1;
                }
                left = newLeft;
            }
            letter[idx] = right;
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
