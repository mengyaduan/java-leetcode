package LcSecond.simulation;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/grumpy-bookstore-owner/description/?envType=daily-question&envId=2024-04-23">生气的书店老板</a>
 **/
public class No1052_MaxSatisfiedBookStoreBoss {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 原始分数
        int scoreZeroMin = 0;
        for (int i = 0; i < customers.length; i++) {
            scoreZeroMin += customers[i] * (1 - grumpy[i]);
        }
        int res = 0;
        for (int i = 0; i < grumpy.length; i++) {
            // 右边扩张
            scoreZeroMin += customers[i] * grumpy[i];
            if (i >= minutes) {
                // 左边收缩
                scoreZeroMin -= customers[i - minutes] * grumpy[i - minutes];
            }
            res = Math.max(res, scoreZeroMin);
        }
        return res;
    }
    @Test(description = "")
    public void test2() throws Exception {
        int[] custom = new int[]{1};
        int[] grumpy = new int[]{1};
        int minutes = 0;
        System.out.println(maxSatisfied(custom, grumpy, minutes));
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] custom = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(maxSatisfied(custom, grumpy, minutes));
    }
}
