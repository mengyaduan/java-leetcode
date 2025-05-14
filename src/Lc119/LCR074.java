package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LCR074 {

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextLeft = intervals[i][0], nextRight = intervals[i][1];
            if (nextLeft > right) {
                // 出现断点，加入结果集合
                result.add(new int[]{left, right});
                left = nextLeft;
                right = nextRight;
            } else if (nextRight >= right) {
                right = nextRight;
            }
        }
        result.add(new int[]{left, right});
        return result.toArray(new int[0][]);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] intervals = new int[][]{
                {1, 3}, {8, 10}, {2, 6}, {15, 18}, {17, 19}
        };
        int[][] x = merge(intervals);
        for (int[] item : x) {
            System.out.println(item[0] + "-" + item[1]);
        }

    }

}
