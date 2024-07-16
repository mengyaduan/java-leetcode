package lc150;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class No56Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();
        int i = 1;
        int start = intervals[0][0], end = intervals[0][1];
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (left > end) {
                // 如果出现gap
                res.add(new int[]{start, end});
                start = left;
                end = right;
            } else {
                if (end <= right) {
                    end = right;
                }
            }
            if (i == intervals.length - 1) {
                // 如果新的是最后一个，则直接加到结果
                res.add(new int[]{start, end});
                break;
            }
            i++;
        }


        int[][] x = new int[res.size()][2];
        for (int j = 0; j < x.length; j++) {
            x[j] = res.get(j);
        }
        return x;
    }

}
