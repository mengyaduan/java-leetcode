package lc75;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75">反转字符串中的元音字母</a>
 */
public class No345_ReversVowels {

    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < s.length() && !isVowels(sArr[left])) {
                left++;
            }
            while (right >= 0 && !isVowels(sArr[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char c = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = c;
            left++;
            right--;
        }
        return new String(sArr);
    }

    public boolean isVowels(char c) {
        String x = "aeiouAEIOU";
        return x.contains(c + "");
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {"leetcode", "leotcede"},
                {"bcd", "bcd"},
                {"bcd", "bcd"},
                {"bam", "bam"},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(String s, String ans) throws Exception {
        Assert.assertEquals(reverseVowels(s), ans);

    }
}
