package lc75;

/**
 * @see <a href="https://leetcode.cn/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75">找到最高海拔</a>
 */
public class No1732_largestAltitude {
    public int largestAltitude(int[] gain) {
        int tmp = 0;
        int res = 0;
        for (int i = 0; i < gain.length; i++) {
            tmp = tmp + gain[i];
            if (tmp > res) {
                res = tmp;
            }
        }
        return res;
    }
}
