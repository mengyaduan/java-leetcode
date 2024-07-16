package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No6Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] helper = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            helper[i] = new StringBuilder();
        }
        int cur = 0;
        int idx = 0;
        boolean upToDown = true;
        char[] arr = s.toCharArray();
        while (idx < arr.length) {
            helper[cur].append(arr[idx]);
            if (upToDown) {
                cur++;
                if (cur == numRows - 1) {
                    upToDown = false;
                }
            } else {
                cur--;
                if (cur == 0) {
                    upToDown = true;
                }
            }
            idx++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(helper[i].toString());
        }
        return res.toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(convert("AB", 1), "AB");
        Assert.assertEquals(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        Assert.assertEquals(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");

    }
}
