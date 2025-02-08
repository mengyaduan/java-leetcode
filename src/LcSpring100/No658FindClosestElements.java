package LcSpring100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No658FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int[] diff = new int[arr.length];
        int deltaMin = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            diff[i] = Math.abs(arr[i] - x);
            if (diff[i] < deltaMin) {
                deltaMin = diff[i];
                idx = i;
            }
        }
        int count = 1;
        int i = idx - 1, j = idx + 1;
        while (count < k) {
            if (i >= 0 && j < arr.length) {
                // 如果可以向两边辐射，则比较大小
                if (diff[i] <= diff[j]) {
                    i--;
                } else {
                    j++;
                }
            } else if (j < arr.length) {
                // i已经小于0了，此时直接增加j即可
                j++;
            } else {
                i--;
            }
            count++;
        }
        for (int l = i + 1; l < j; l++) {
            result.add(arr[l]);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1));
        System.out.println(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));

    }

}
