package lc150;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No3LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> helper = new HashMap<>();
        int head = 0;
        int len = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (helper.containsKey(c) && helper.get(c) >= head) {
                head = helper.get(c) + 1;
            }
            helper.put(c, i);
            len = Math.max(len, i - head + 1);
        }
        return len;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"abba", 2},
                {"pwwkew", 3}, {"abcabcbb", 3},
                {"bbbbb", 1},
                {"b", 1},
                {"bb", 1},
                {"b_b", 2},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int expected) {
        int res = lengthOfLongestSubstring(s);
        Assert.assertEquals(res, expected);

    }
}
