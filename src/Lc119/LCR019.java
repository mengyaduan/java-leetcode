package Lc119;

public class LCR019 {

    boolean hasError;

    public boolean validPalindrome(String s) {
        hasError = false;
        char[] sc = s.toCharArray();
        return valid(sc, 0, s.length() - 1);
    }

    private boolean valid(char[] sc, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (sc[i] == sc[j]) {
            // 如果相等，直接收缩
            return valid(sc, i + 1, j - 1);
        }
        if (!hasError) {
            // 如果不一致，那么有一次修复机会
            hasError = true;
            return valid(sc, i + 1, j) || valid(sc, i, j - 1);
        }
        return false;
    }

}
