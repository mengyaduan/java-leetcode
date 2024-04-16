package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/find-k-closest-elements/description/">找到距离为k的数</a>
 **/
public class No658_FindClosetElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (x > arr[arr.length - 1]) {
            // 所有值都小于x，那么直接返回最后k个就行了
            for (int i = arr.length - k; i < arr.length; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        if (x < arr[0]) {
            // 所有值都大于x，返回开始的k个
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        // 有序数组，找到距离x最小的数的坐标
        int closetIdxGtX = -1;
        int closetIdxLtX = -1;
        int l = 0, r = arr.length - 1;
        // 找到大于x的最小值
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                closetIdxGtX = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= x) {
                closetIdxLtX = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 如果大于x的最小值和小于x的最大值都找到了，比较一下谁近
        int a = calcDistance(x, arr[closetIdxGtX]);
        int b = calcDistance(x, arr[closetIdxLtX]);
        int start = closetIdxLtX;
        if (a  < b) {
            start = closetIdxGtX;
        }
        // 找到k个就行了
        int num = 1;
        int leftCur = start - 1;
        int rightCur = start + 1;
        while (num < k) {
            if (leftCur < 0) {
                rightCur++;
            } else if (rightCur > arr.length - 1) {
                leftCur--;
            } else if (calcDistance(arr[leftCur], x) < calcDistance(arr[rightCur], x)) {
                leftCur--;
            } else if (calcDistance(arr[leftCur], x) > calcDistance(arr[rightCur], x)) {
                rightCur++;
            } else if (calcDistance(arr[leftCur], x) == calcDistance(arr[rightCur], x)) {
                leftCur--;
            }
            num++;
        }
        for (int i = leftCur + 1; i <= leftCur + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private int calcDistance(int m, int x) {
        return Math.abs(m - x);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(findClosestElements(arr, 4, 3));
        System.out.println(findClosestElements(arr, 4, -1));

    }
}
