package Lc.KrahetsInterview.DoublePointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">最长不重复子串</a>
 **/
public class No3 {

    public int lengthOfLongestSubstring(String s) {
        int maxRes = 0;
        if (s.length() <= 1) {
            return s.length();
        }
        HashSet<Character> mySet = new HashSet<>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (!mySet.contains(s.charAt(j))) {
                // 如果没包含，直接加入set，并右移
                mySet.add(s.charAt(j));
                j++;
            } else {
                // 当前值已包含，需要缩左边框
                while (i < j) {
                    if (s.charAt(i) != s.charAt(j)) {
                        mySet.remove(s.charAt(i));
                        i++;
                    } else {
                        i++;
                        j++;
                        break;
                    }
                }
            }
            maxRes = maxRes > mySet.size() ? maxRes : mySet.size();

        }
        return maxRes;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"pwwkew", 3},
                {"abcabcbb", 3},
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

