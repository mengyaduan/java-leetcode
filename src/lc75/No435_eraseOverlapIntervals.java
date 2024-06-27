package lc75;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @see <a href="https://leetcode.cn/problems/non-overlapping-intervals/description/?envType=study-plan-v2&envId=leetcode-75">无重叠区间</a>
 */
public class No435_eraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int endTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= endTime) {
                res++;
                endTime = intervals[i][1];
            }
        }
        return intervals.length - res;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[][] intervals = new int[][]{
                {1, 3},
                {3, 4},
                {1, 2},
                {2, 3},
        };
        System.out.println(eraseOverlapIntervals(intervals));

    }

}
