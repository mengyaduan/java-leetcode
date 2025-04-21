package Lc119;

import java.util.ArrayList;

/**
 * LCR 058
 */
public class MyCalendar {

    ArrayList<int[]> helper;

    public MyCalendar() {
        helper = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // [start, end)
        for (int[] timeSpan : helper) {
            // 任一切片存在交集，则直接返回
            if (!(start >= timeSpan[1] || end <= timeSpan[0])) {
                return false;
            }
        }
        helper.add(new int[]{start, end});
        return true;
    }

}
