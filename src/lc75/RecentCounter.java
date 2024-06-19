package lc75;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75">最近的请求次数</a>
 */
public class RecentCounter {

    Queue<Integer> helper;

    public RecentCounter() {
        helper = new ArrayDeque<>();
    }

    public int ping(int t) {
        helper.add(t);
        while (!helper.isEmpty() && t - helper.peek() > 3000) {
            helper.poll();
        }
        return helper.size();
    }
}
