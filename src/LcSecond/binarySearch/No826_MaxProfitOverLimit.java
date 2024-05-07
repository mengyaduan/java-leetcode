package LcSecond.binarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/most-profit-assigning-work/description/">安排工作以达到最大收益</a>
 */
public class No826_MaxProfitOverLimit {


    /**
     * 用来存储小于等于x难度的最大利润
     */
    HashMap<Integer, Integer> memo;

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        memo = new HashMap<>();
        // 现将worker排序，从小到大
        Arrays.sort(worker);
        int maxProfit = 0;
        // 循环worker，计算profit
        for (int i = 0; i < worker.length; i++) {
            int topD = worker[i];
            maxProfit += totalProfitLteD(topD, difficulty, profit);
        }
        return maxProfit;
    }

    private int totalProfitLteD(int topD, int[] difficulty, int[] profit) {
        if (memo.containsKey(topD)) {
            return memo.get(topD);
        }
        // 先将difficult和profit联合，然后先按照difficult排序，在按照profit排序
        int[][] diffPro = new int[difficulty.length][2];
        for (int i = 0; i < diffPro.length; i++) {
            diffPro[i][0] = difficulty[i];
            diffPro[i][1] = profit[i];
        }
        // 将所有小于等于topD的取出来
        int[][] proDiff = Arrays.stream(diffPro).filter(array -> array[0] <= topD).toArray(int[][]::new);
        if (proDiff.length == 0) {
            return 0;
        }
        Arrays.sort(proDiff, (a, b) -> {
            return b[1] - a[1];
        });
        int maxPro = proDiff[0][1];
        for (int i = 0; i < proDiff.length; i++) {
            memo.put(proDiff[i][0], maxPro);
        }
        return maxPro;
    }

    @Test(description = "")
    public void test() throws Exception {
        memo = new HashMap<>();
        int[] diff = new int[]{20, 40, 80, 60};
        int[] profit = new int[]{70, 30, 10, 50};
        totalProfitLteD(70, diff, profit);
    }

    @Test(description = "")
    public void tests123() throws Exception {
        int[] diff = new int[]{85, 47, 57};
        int[] profit = new int[]{24, 66, 99};
        int x = maxProfitAssignment(diff, profit, new int[]{40, 25, 25});
        Assert.assertEquals(x, 0);
    }

    @Test(description = "")
    public void testse() throws Exception {
        int[] diff = new int[]{2, 4, 6, 8, 10};
        int[] profit = new int[]{10, 20, 30, 40, 50};
        int x = maxProfitAssignment(diff, profit, new int[]{4, 5, 6, 7});
        Assert.assertEquals(x, 100);
    }

}
