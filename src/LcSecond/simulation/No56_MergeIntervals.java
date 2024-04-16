package LcSecond.simulation;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/merge-intervals/description/">合并区间</a>
 **/
public class No56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> {
            return x[0] - y[0];
        });
        result.add(intervals[0]);
        int lastTail = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= lastTail) {
                if (intervals[i][1] > lastTail) {
                    result.get(result.size() - 1)[1] = intervals[i][1];
                    lastTail = intervals[i][1];
                }
            } else {
                result.add(intervals[i]);
                lastTail = intervals[i][1];
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    @Test(description = "")
    public void test() throws Exception {
//        int[][] intervals = new int[][]{{4, 5}, {1, 4}, {2, 3}};
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] x = merge(intervals);
        System.out.println(x);


    }
}

