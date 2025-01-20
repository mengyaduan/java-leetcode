package LcSpring100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No933
 */
public class RecentCounter {

    Deque<Integer> helper;

    public RecentCounter() {
        helper = new ArrayDeque<>();
    }

    public int ping(int t) {
        int start = t - 3000;
        int end = t;
        while (!helper.isEmpty() && helper.peekFirst() < start) {
            helper.pop();
        }
        helper.addLast(end);
        return helper.size();
    }
}

