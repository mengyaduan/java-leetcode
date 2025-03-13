package Lc119;

import org.testng.annotations.Test;

public class LCR002 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        char[] ac = a.toCharArray(), bc = b.toCharArray();
        int i = a.length() - 1, j = b.length() - 1;
        char carry = '0';
        while (i >= 0 || j >= 0 || carry == '1') {
            char an = i >= 0 ? ac[i--] : '0';
            char bn = j >= 0 ? bc[j--] : '0';
            if (an == bn) {
                result.insert(0, carry);
                carry = an;
            } else {
                result.insert(0, carry == '1' ? '0' : '1');
            }
        }
        return result.toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(addBinary("1010", "1001011"));

    }
}
