package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No137SingleNumber {


    public int singleNumber(int[] nums) {
        int[] resBit = new int[32];
        for (int num : nums) {
            int i = 31;
            while (num != 0) {
                resBit[i] += num & 1;
                num >>>= 1;
                i--;
            }
        }
        int res = 0;
        for (int i = 0; i < resBit.length; i++) {
            if (resBit[i] != 0 && resBit[i] % 3 != 0) {
                res += 1 << (31 - i);
            }
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));

    }

}
