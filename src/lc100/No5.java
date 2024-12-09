package lc100;

import org.testng.annotations.Test;

import java.util.Arrays;

public class No5 {

    String result;

    String[][] helper;

    public String longestPalindrome(String s) {
        result = "";
        helper = new String[s.length() + 1][s.length() + 1];
        for (String[] row : helper) {
            Arrays.fill(row, "");
        }
        result = dp(s.toCharArray(), 0, s.length() - 1);
        return result;
    }

    private String dp(char[] sc, int i, int j) {
        if (i == j) {
            helper[i][j] = String.valueOf(sc[i]);
            return helper[i][j];
        }
        if (i - j == 1 || i - j == -1) {
            String res = sc[i] == sc[j] ? new String(sc, i, 2) : new String(sc, i, 1);
            helper[i][j] = res;
            return res;
        }
        if (!helper[i][j].isEmpty()) {
            return helper[i][j];
        }
        String res = "";
        String res1 = dp(sc, i + 1, j);
        String res2 = dp(sc, i, j - 1);
        res = res1.length() > res2.length() ? res1 : res2;
        String res3 = dp(sc, i + 1, j - 1);
        if (sc[i] == sc[j] && res3.length() == j - i - 1) {
            res = sc[i] + res3 + sc[j];
        }
        helper[i][j] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));

    }
}
