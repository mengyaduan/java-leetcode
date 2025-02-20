package LcSpring100;

import org.testng.annotations.Test;

import java.util.HashMap;

public class No409LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> helper = new HashMap<>();
        for (char c : s.toCharArray()) {
            helper.put(c, helper.getOrDefault(c, 0) + 1);
        }
        int letters = 0;
        // 是否有单独出现的字符，决定最终长度是否加一
        boolean hasSingle = false;
        for (int val : helper.values()) {
            if (val % 2 == 0) {
                letters += val;
            } else {
                hasSingle = true;
                if (val > 1) {
                    letters += val - 1;
                }
            }
        }
        return letters + (hasSingle ? 1 : 0);
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));

    }
}
