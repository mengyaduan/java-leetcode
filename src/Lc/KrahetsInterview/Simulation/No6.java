package Lc.KrahetsInterview.Simulation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/description/">z字型变换</a>
 **/
public class No6 {
    public String convert(String s, int numRows) {
        if (numRows >= s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int start = i;
            // 每行的首尾是很好计算的，0,1,2...rows-1
            sb.append(s.charAt(start));
            // 首尾两行没有subStep
            int subStep = i == 0 || i == numRows - 1 ? -1 : 2 * (numRows - i) - 2;
            while (start < s.length()) {
                // 同一行，之字形每两列之间只有一个数字，且subStep是固定的
                if (subStep > 0 && start + subStep < s.length()) {
                    sb.append(s.charAt(start + subStep));
                }
                if (start + step < s.length()) {
                    sb.append(s.charAt(start + step));
                }
                start = start + step;
            }
        }
        return sb.toString();
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

