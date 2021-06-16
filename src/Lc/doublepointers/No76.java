package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/"</a>
 **/
public class No76 {

    /**
     * 解题思路：
     **/

    public String minWindow(String s, String t) {
        int lenT = t.length();
        int lenS = s.length();
        if (lenT > lenS) {
            return "";
        }
        // 录入t的数据
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }
        // 需要出现的字符数
        int required = dictT.size();
        // 当前出现的字典
        Map<Character, Integer> dictNow = new HashMap<>(12);

        // windowSize, start, end
        int[] ans = {-1, 0, 0};

        int left = 0;
        int right = 0;
        // 滑动窗口中，已经满足条件的字符
        int satisfyCharacters = 0;

        while (right < lenS) {
            char now = s.charAt(right);
            int count = dictNow.getOrDefault(now, 0);
            dictNow.put(now, count + 1);
            if (dictT.containsKey(now) && dictNow.get(now).intValue() == dictT.get(now).intValue()) {
                satisfyCharacters++;
            }
            while (satisfyCharacters == required && left <= right) {
                char c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                dictNow.put(c, dictNow.get(c) - 1);
                if (dictT.containsKey(c) && dictNow.get(c).intValue() < dictT.get(c).intValue()) {
                    satisfyCharacters--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"ADOBECODEBANC", "ABC", "BANC"},
                {"ADOBECODEBANC", "AB", "BA"},
                {"A", "A", "A"},
                {"", "A", ""},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, String expected) {
        String res = minWindow(s, t);
        Assert.assertEquals(res, expected);
    }
}
