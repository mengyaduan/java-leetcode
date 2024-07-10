package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No134CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] sum = new int[n];

        boolean hasStarted = false;
        int totalNow = 0;
        int pos = -1;
        for (int i = 0; i < n; i++) {
            sum[i] = gas[i] - cost[i];
            if (hasStarted) {
                if (totalNow + sum[i] < 0) {
                    // 走不下去了，需要重新开始
                    hasStarted = false;
                    totalNow = 0;
                    pos = -1;
                } else {
                    totalNow += sum[i];
                }
            } else {
                if (sum[i] >= 0) {
                    // 开始新的轮回
                    hasStarted = true;
                    totalNow += sum[i];
                    pos = i;
                }
            }
        }
        // 如果pos不等于-1，那么还需要从头走到pos
        if (pos == -1) {
            return pos;
        }
        for (int i = 0; i < pos; i++) {
            totalNow += sum[i];
            if (totalNow < 0) {
                return -1;
            }
        }
        return pos;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2}), 0);
        System.out.println(canCompleteCircuit(new int[]{3}, new int[]{3}));
        System.out.println(canCompleteCircuit(new int[]{3}, new int[]{4}));
        System.out.println(canCompleteCircuit(new int[]{5}, new int[]{4}));
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));


    }
}
