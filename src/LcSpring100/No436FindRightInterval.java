package LcSpring100;

import java.util.Arrays;
import java.util.HashMap;

public class No436FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = intervals[i][1];
        }
        // 存储原始坐标
        HashMap<int[], Integer> helper = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            helper.put(intervals[i], i);
        }
        // 对intervals进行start排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        // 针对每一个end，进行二分搜索
        for (int i = 0; i < result.length; i++) {
            int target = result[i];
            int res = binarySearch(intervals, target);
            result[i] = res == -1 ? -1 : helper.get(intervals[res]);
        }
        return result;
    }

    private int binarySearch(int[][] intervals, int target) {
        int l = 0, r = intervals.length - 1;
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (intervals[mid][0] >= target) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }


}
