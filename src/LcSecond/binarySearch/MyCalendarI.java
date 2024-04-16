package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.com/problems/my-calendar-i/description/"></a>
 **/
public class MyCalendarI {

    ArrayList<Integer> startDay;
    ArrayList<Integer> endDay;


    public MyCalendarI() {
        startDay = new ArrayList<>();
        endDay = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (startDay.isEmpty()) {
            startDay.add(start);
            endDay.add(end);
            return true;
        }
        // 找到需要插入start的地方，小于start的最大idx
        int lessThanStart = -1;
        int l = 0, r = startDay.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (startDay.get(mid) > start) {
                r = mid - 1;
            } else if (startDay.get(mid) < start) {
                lessThanStart = mid;
                l = mid + 1;
            } else {
                // start已经重叠了，不可能insert了
                return false;
            }
        }
        // 找到小于start的最大的idx，start如果可以，只能插入到idx后面，所以需要满足 start >= endDay(idx) && end <= startDay(idx+1)
        boolean condA = true, condB = true;
        if (lessThanStart == -1) {
            // 没有找到小于start的数，当前所有时间起点都在start之后
            condB = end <= startDay.get(0);
        } else if (lessThanStart == startDay.size() - 1) {
            // 所有时间起点都小于start
            condA = start >= endDay.get(lessThanStart);
        } else {
            condA = start >= endDay.get(lessThanStart);
            condB = end <= startDay.get(lessThanStart + 1);
        }
        if (condA && condB) {
            startDay.add(lessThanStart + 1, start);
            endDay.add(lessThanStart + 1, end);
            return true;
        } else {
            return false;
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        MyCalendarI myCalendarI = new MyCalendarI();
        myCalendarI.book(1, 3);
        myCalendarI.book(6, 9);
        myCalendarI.book(10, 12);
        myCalendarI.book(9, 11);
        myCalendarI.book(4, 6);
        myCalendarI.book(3, 4);

    }
}
