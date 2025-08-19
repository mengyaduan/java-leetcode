package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc009 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] ans = new int[26];
        for (char c : p.toCharArray()) {
            ans[c - 'a'] += 1;
        }
        int size = p.length();
        int i = 0, j = 0;
        int winSize = 0;
        int[] cur = new int[26];
        char[] sc = s.toCharArray();
        while (i < s.length() - size + 1) {
            while (j < sc.length && winSize < size) {
                // 左闭右开，扩窗口
                cur[sc[j] - 'a'] += 1;
                j++;
                winSize = j - i;
            }
            if (winSize != size) {
                break;
            }
            if (isMatch(ans, cur)) {
                result.add(i);
            }
            // 缩窗口
            cur[sc[i] - 'a'] -= 1;
            i++;
            winSize -= 1;
        }
        return result;
    }

    private boolean isMatch(int[] ans, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (ans[i] != cur[i]) {
                return false;
            }
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findAnagrams("cbaebabacd", "abc"));

    }

}
