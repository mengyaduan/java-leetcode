package Lc.KrahetsInterview.Hash;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/valid-anagram/description/">有效的字母异位词</a>
 **/
public class No242 {

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character item : s.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (Character item : t.toCharArray()) {
            if (!map.containsKey(item)) {
                return false;
            }
            map.put(item, map.get(item) - 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramOld(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character item : s.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (Character item : t.toCharArray()) {
            if (!map.containsKey(item)) {
                return false;
            }
            map.put(item, map.get(item) - 1);
            if (map.get(item) == 0) {
                map.remove(item);
            }
        }
        return map.isEmpty();
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {"anagram", "nagaram", true},
                {"anagram", "agaram", false},
                {"anagram", "", false},

        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, boolean expected) {
        boolean res = isAnagram(s, t);
        Assert.assertEquals(res, expected);

    }

}

