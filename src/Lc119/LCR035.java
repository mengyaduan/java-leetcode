package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LCR035 {

    public int findMinDifference(List<String> timePoints) {
        int result = Integer.MAX_VALUE;
        HashMap<String, Integer> helper = new HashMap<>();
        int[][] time = new int[timePoints.size()][2];
        for (int i = 0; i < timePoints.size(); i++) {
            String item = timePoints.get(i);
            String[] hm = item.split(":");
            if (helper.containsKey(item)) {
                return 0;
            }
            helper.put(item, 1);
            time[i][0] = Integer.parseInt(hm[0]);
            time[i][1] = Integer.parseInt(hm[1]);
        }
        Arrays.sort(time, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        // 计算一下从头到尾的时间数，然后再比较首尾
        for (int i = 1; i < time.length; i++) {
            int gap = calculateGap(time[i - 1], time[i]);
            result = Math.min(result, gap);
        }
        int ht = calculateGap(time[time.length - 1], time[0]);
        result = Math.min(result, ht);
        return result;
    }

    private int calculateGap(int[] t0, int[] t1) {
        if (t1[0] < t0[0] || (t1[0] == t0[0] && t1[1] < t0[1])) {
            // 只要是t1 < t0， 就需要加24小时
            t1[0] += 24;
        }
        int hGap = t1[0] - t0[0];
        int mGap = t1[1] - t0[1];
        return hGap * 60 + mGap;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<String> times = new ArrayList<>(Arrays.asList("13:15", "13:16"));
        System.out.println(findMinDifference(times));

    }

}
