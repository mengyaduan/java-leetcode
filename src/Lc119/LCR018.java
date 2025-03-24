package Lc119;

import org.testng.annotations.Test;

public class LCR018 {
    public boolean isPalindrome(String s) {
        char[] sc = s.toLowerCase().toCharArray();
        int i = 0;
        int j = sc.length - 1;
        while (i < j) {
            while (i < s.length() && !valid(sc[i])) {
                i++;
            }
            while (j >= 0 && !valid(sc[j])) {
                j--;
            }
            if (i > j) {
                break;
            }
            if (sc[i] != sc[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean valid(char c) {
        return 'a' <= c && c <= 'z' || '0' <= c && c <= '9';
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(",.,.,,. ,.,. ,. "));
        System.out.println(isPalindrome(",.,.,,x. ,.,. ,. "));

    }
}
