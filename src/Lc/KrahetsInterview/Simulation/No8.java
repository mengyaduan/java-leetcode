package Lc.KrahetsInterview.Simulation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="">字符串转换整数</a>
 **/
public class No8 {


    public int myAtoi(String s) {
        // 去掉前导空格
        if (s.isEmpty()) {
            return 0;
        }
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        if (start == s.length() || (!charIsSign(s.charAt(start)) && !charIsNumber(s.charAt(start)))) {
            // 找不到首位非空字符 || 首位既不是符号也不是数字，直接return0
            return 0;
        }
        char sign = charIsSign(s.charAt(start)) ? s.charAt(start) : '+';
        start = charIsSign(s.charAt(start)) ? start + 1 : start;
        int end = start;
        while (end < s.length() && charIsNumber(s.charAt(end))) {
            end++;
        }
        if (end == start) {
            // 如果符号后面跟了字母
            return 0;
        }
        String number = s.substring(start, end);
        System.out.println("找到的字符串为：" + number);
        System.out.println("符号位为：" + sign);
        // 抛开符号位，去掉首位0，比位数，如果位数小于2^31-1，可以直接返回
        while (start < s.length() && s.charAt(start) == '0') {
            start++;
        }
        // 如果只有0，那么返回0
        if (start == end) {
            return 0;
        }
        number = s.substring(start, end);
        System.out.println("去掉首位符号位和首位的0后，字符串为：" + number);

        // 位数小于最大值或最小值时，都是一定可以转成int的
        if (number.length() < (Integer.MAX_VALUE + "").length()) {
            return sign == '+' ? Integer.parseInt(number) : -Integer.parseInt(number);
        }
        // 位数大于最大值或最小值时，直接返回最大值或最小值
        if (number.length() > (Integer.MAX_VALUE + "").length()) {
            return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        // 位数相同时，从高位逐位像低位比，根据正负数，一旦出现比最大值大，直接返回最大值
        String maxString = "";
        maxString = sign == '+' ? Integer.MAX_VALUE + "" : (Integer.MIN_VALUE + "").substring(1);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) > maxString.charAt(i)) {
                // number从高到底任意一位溢出，都将要返回最大值或最小值
                return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else if (number.charAt(i) < maxString.charAt(i)) {
                // 任意一位小于max以后，都可以直接parse了
                return Integer.parseInt(sign + number);
            }
        }
        return Integer.parseInt(sign + number);
    }

    private boolean charIsNumber(char c) {
        return c >= 48 && c <= 57;
    }

    private boolean charIsSign(char c) {
        return c == '-' || c == '+';
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {" ", 0},
                {"000000000000000000", 0},
                {"000000-123", 0},
                {"  -abc 04193a with words", 0},
                {"  -abc dalkfj-0182910014193 with words", 0},
                {"  -abc dalkfj182910014112132293 with words", 0},
                {"  -abc dalkfj-001829  10014193 with words", 0},
                {" 2147483649", 2147483647},
                {" -2147493648", -2147483648},
                {"-2147483648", -2147483648},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int expected) {
        int res = myAtoi(s);
        Assert.assertEquals(res, expected);

    }

    @Test(description = "")
    public void test123sou() throws Exception {
        System.out.println(Integer.MIN_VALUE);

    }
}

