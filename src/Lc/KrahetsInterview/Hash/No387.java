package Lc.KrahetsInterview.Hash;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/first-unique-character-in-a-string/description/">找到首个不重复的字符</a>
 **/
public class No387 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character item : s.toCharArray()) {
            if (map.containsKey(item)) {
                map.put(item, -1);
            } else {
                map.put(item, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"leetcode", 0},
                {"loveleetcode", 2},
                {"aabb", -1},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int expected) {
        int res = firstUniqChar(s);
        Assert.assertEquals(res, expected);

    }

}

