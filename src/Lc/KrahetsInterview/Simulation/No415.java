package Lc.KrahetsInterview.Simulation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.com/problems/add-strings/description/">字符数字相加</a>
 **/
public class No415 {

    public String addStrings(String num1, String num2) {
        ArrayList<Integer> reverseRes = new ArrayList<>();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int flag = 0;

        while (i >= 0 && j >= 0) {
            int s = num1.charAt(i) - '0' + num2.charAt(j) - '0' + flag;
            flag = s / 10;
            reverseRes.add(s % 10);
            i--;
            j--;
        }
        while (j >= 0) {
            int s = num2.charAt(j) - '0' + flag;
            flag = s / 10;
            reverseRes.add(s % 10);
            j--;
        }
        while (i >= 0) {
            int s = num1.charAt(i) - '0' + flag;
            flag = s / 10;
            reverseRes.add(s % 10);
            i--;
        }
        if (flag == 1) {
            reverseRes.add(1);
        }
        StringBuilder res = new StringBuilder();
        for (int k = reverseRes.size() - 1; k >= 0; k--) {
            res.append(reverseRes.get(k));
        }
        return res.toString();
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"123", "751", ""},
                {"123", "759", ""},
                {"163", "751", ""},
                {"183", "759", ""},
                
                {"1231231", "759", ""},
                {"1231231", "98239283", ""},
                {"99999", "1", ""},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String num1, String num2, String expected) {
        String res = addStrings(num1, num2);
        System.out.println(res);
        Assert.assertEquals(res, Integer.parseInt(num1) + Integer.parseInt(num2) + "");

    }

}

