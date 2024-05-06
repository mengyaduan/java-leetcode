package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/description/">第k小的分数</a>
 */
public class No786_KthSmallestPrimeFractionOverLimit {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        // 初始化
        ArrayList<ArrayList<int[]>> helper = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            ArrayList<int[]> item = new ArrayList<>();
            for (int j = 0; j < n - 1; j++) {
                item.add(new int[]{arr[j], arr[i]});
            }
            helper.add(item);
        }
        int[] curs = new int[n - 1];

        int count = 0;
        int[] tmp = new int[2];
        while (count < k) {
            double res = Double.MAX_VALUE;
            int flag = -1;
            for (int i = 0; i < n - 1; i++) {
                if (curs[i] >= helper.get(i).size()) {
                    continue;
                }
                int[] p = helper.get(i).get(curs[i]);
                double item = p[0] * 1.0 / p[1];
                if (item < res) {
                    res = item;
                    tmp = p;
                    flag = i;
                }
            }
            curs[flag] = curs[flag] + 1;
            count++;
        }
        return tmp;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[] arr = new int[]{1, 2, 3, 5};
        int[] x = kthSmallestPrimeFraction(arr, 3);
        System.out.println(x[0] + "," + x[1]);
    }

}
