package LC100Again;


import java.util.ArrayList;
import java.util.Arrays;

public class Lc014 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int left = -1, right = -1;
        ArrayList<int[]> resultOri = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                left = intervals[i][0];
                right = intervals[i][1];
            } else if (intervals[i][0] > right) {
                resultOri.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(right, intervals[i][1]);
            }
            if (i == intervals.length - 1) {
                // 已经是最后一个了，需要追加
                resultOri.add(new int[]{left, right});
            }
        }
        int[][] result = new int[resultOri.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = resultOri.get(i)[0];
            result[i][1] = resultOri.get(i)[1];
        }
        return result;
    }

}
