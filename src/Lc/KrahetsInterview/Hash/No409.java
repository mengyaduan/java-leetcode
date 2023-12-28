package Lc.KrahetsInterview.Hash;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindrome/description/">最长回文串</a>
 **/
public class No409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character item : s.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int res = 0;
        int oddFlag = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                res += entry.getValue();
            } else {
                res += entry.getValue() - 1;
                oddFlag = 1;
            }
        }
        return res + oddFlag;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {"abccccdd", 7},
                {"aaaaaccc", 7},
                {"a", 1},
                {"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth", 983},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int expected) {
        int res = longestPalindrome(s);
        Assert.assertEquals(res, expected);


    }

}

