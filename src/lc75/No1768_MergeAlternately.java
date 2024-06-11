package lc75;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75">交替合并字符串</a>
 */
public class No1768_MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && j < word2.length()) {
                res.append(word1.charAt(i) + "" + word2.charAt(j));
            } else if (i < word1.length()) {
                res.append(word1.substring(i));
                break;
            } else {
                res.append(word2.substring(j));
                break;
            }
            i++;
            j++;
        }
        return res.toString();
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {"abc", "def", "adbecf"},
                {"abc", "d", "adbc"},
                {"ac", "def", "adcef"},
                {"ac", "", "ac"},
                {"", "ac", "ac"},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(String a, String b, String res) throws Exception {
        Assert.assertEquals(mergeAlternately(a, b), res);
    }
}
