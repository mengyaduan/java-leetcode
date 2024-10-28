package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static DataStruct.tools.printIntArray;

public class No56 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int leftItem = intervals[i][0];
            int rightItem = intervals[i][1];
            if (leftItem > right) {
                // 有gap，不可以合并，直接更新左右值
                result.add(new int[]{left, right});
                left = leftItem;
                right = rightItem;
            } else {
                // 有重叠，判断如何合并
                left = Math.min(leftItem, left);
                right = Math.max(rightItem, right);
            }
        }
        result.add(new int[]{left, right});
        return result.toArray(new int[result.size()][2]);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] intArray = {
                {15, 18},
                {1, 6},
                {1, 3},
                {8, 10},
                {2, 6},
        };

        int[][] res = merge(intArray);
        printIntArray(res);
    }
}
