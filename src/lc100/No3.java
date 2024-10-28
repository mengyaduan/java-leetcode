package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class No3 {


    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashMap<Character, Integer> helper = new HashMap<>();
        int l = 0, r = 0;
        char[] c = s.toCharArray();
        while (r < c.length) {
            char nowAt = c[r];
            if (helper.containsKey(nowAt) && helper.get(nowAt) >= l) {
                l = helper.get(nowAt) + 1;
            }
            helper.put(nowAt, r);
            r++;
            result = Math.max(result, r - l);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(lengthOfLongestSubstring("abba"), 2);
        Assert.assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
        Assert.assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
        Assert.assertEquals(lengthOfLongestSubstring("bbbbbbb"), 1);
        Assert.assertEquals(lengthOfLongestSubstring(""), 0);

    }
}
