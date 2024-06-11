package lc75;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75">字符串的最大公因子</a>
 */
public class No1071_GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // a长b短
        String a, b;
        if (str1.length() > str2.length()) {
            a = str1;
            b = str2;
        } else if (str1.length() < str2.length()) {
            a = str2;
            b = str1;
        } else {
            if (str1.equals(str2)) {
                return str1;
            } else {
                return "";
            }
        }
        if (!a.contains(b) || !a.startsWith(b)) {
            // a不包含b，或者a包含b，但开头和b不一样
            return "";
        }
        a = a.substring(b.length());
        return gcdOfStrings(a, b);
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals((gcdOfStrings("ABCABC", "ABC")), "ABC");
        Assert.assertEquals((gcdOfStrings("ABABAB", "ABAB")), "AB");
        Assert.assertEquals((gcdOfStrings("LEET", "CODE")), "");


    }
}
