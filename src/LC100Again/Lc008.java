package LC100Again;


import org.testng.annotations.Test;

import java.util.HashMap;

public class Lc008 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        HashMap<Character, Integer> helper = new HashMap<>();
        int i = 0, j = 0;
        while (j < c.length) {
            if (helper.containsKey(c[j])) {
                // 如果要追加的字符已经出现过，则需要将窗口缩小到上次出现位置的下一个
                int dupIdx = helper.get(c[j]);
                for (; i <= dupIdx; i++) {
                    helper.remove(c[i]);
                }
            }
            helper.put(c[j], j);
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

}
