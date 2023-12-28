package Lc.KrahetsInterview.Hash;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/isomorphic-strings/description/">同构字符串</a>
 **/
public class No205 {

    public boolean isIsomorphicPureLetters(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] lettersMap = new int[26];
        int[] lettersMapR = new int[26];
        Arrays.fill(lettersMap, -1);
        Arrays.fill(lettersMapR, -1);

        for (int i = 0; i < s.length(); i++) {
            int letterIndex = s.charAt(i) - 97;
            if (lettersMap[letterIndex] == -1) {
                // 没有映射过
                if (lettersMapR[t.charAt(i) - 97] != -1) {
                    // t里面那个字母已经用过了，也不行
                    return false;
                }
                lettersMap[letterIndex] = t.charAt(i) - 97;
                lettersMapR[t.charAt(i) - 97] = 1;
            } else {
                if (lettersMap[letterIndex] != t.charAt(i) - 97) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> mapR = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (mapR.containsKey(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                mapR.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {"abb", "bcc", true},
                {"foo", "bar", false},
                {"paper", "title", true},
                {"badc", "baba", false},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, boolean expected) {
        boolean res = isIsomorphic(s, t);
        Assert.assertEquals(res, expected);
    }

}

