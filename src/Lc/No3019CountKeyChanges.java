package Lc;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-changing-keys/?envType=daily-question&envId=2025-01-07"></a>
 */
public class No3019CountKeyChanges {
    public int countKeyChanges(String s) {
        int result = 0;
        char[] cs = s.toLowerCase().toCharArray();
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != cs[i - 1]) {
                result += 1;
            }
        }
        return result;
    }

}
