package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/description/">第k小的分数</a>
 */
public class No786_KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            double i1 = arr[a[0]] * 1.0 / arr[a[1]], i2 = arr[b[0]] * 1.0 / arr[b[1]];
            return Double.compare(i1, i2);
        });

        for (int i = n - 1; i > 0; i--) {
            q.add(new int[]{0, i});
        }

        while (k > 1) {
            int[] poll = q.poll();
            int i = poll[0], j = poll[1];
            if (i + 1 < j) {
                q.add(new int[]{i + 1, j});
            }
            k--;
        }
        int[] poll = q.poll();
        return new int[]{arr[poll[0]], arr[poll[1]]};
    }


    @Test(description = "")
    public void test() throws Exception {
        int[] arr = new int[]{1, 2, 3, 5};
        int[] x = kthSmallestPrimeFraction(arr, 3);
        System.out.println(x[0] + "," + x[1]);
    }

}
