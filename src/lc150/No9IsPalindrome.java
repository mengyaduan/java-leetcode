package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/palindrome-number/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No9IsPalindrome {
    public boolean isPalindrome(int x) {
        char[] cs = (x + "").toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
