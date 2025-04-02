package Lc119;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LCR 042
 */
public class RecentCounter {

    Deque<Integer> helper;

    public RecentCounter() {
        helper = new ArrayDeque<>();
    }

    public int ping(int t) {
        helper.addLast(t);
        int leftBound = t - 3000;
        while (!helper.isEmpty() && helper.peekFirst() < leftBound) {
            helper.pollFirst();
        }
        return helper.size();
    }
}
