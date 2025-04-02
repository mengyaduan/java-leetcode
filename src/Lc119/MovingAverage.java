package Lc119;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LCR 041
 */
public class MovingAverage {

    int cap;
    int total;
    Deque<Integer> helper;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.cap = size;
        helper = new ArrayDeque<>();
        total = 0;
    }

    public double next(int val) {
        if (helper.size() < this.cap) {
            helper.addLast(val);
            total += val;
            return (total * 1.0) / helper.size();
        }
        total -= helper.pollFirst();
        return next(val);
    }

}
