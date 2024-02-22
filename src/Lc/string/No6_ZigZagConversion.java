package Lc.string;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/description/">z字型变换</a>
 **/
public class No6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int count = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            sbs[count].append(c);
            if (count == 0 || count == numRows - 1) {
                flag = -flag;
            }
            count += flag;
        }
        StringBuilder res = sbs[0];
        for (int i = 1; i < sbs.length; i++) {
            res.append(sbs[i]);
        }
        return res.toString();
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"},
                {"PAYPALISHIRING", 4, "PINALSIGYAHRPI"},
                {"P", 1, "P"},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int num, String expected) {
        String res = convert(s, num);
        Assert.assertEquals(res, expected);

    }

}

