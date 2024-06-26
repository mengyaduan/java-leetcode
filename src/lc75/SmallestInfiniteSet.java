package lc75;

import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.cn/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75">无限集中的最小数字</a>
 */
public class SmallestInfiniteSet {

    PriorityQueue<Integer> helper;

    public SmallestInfiniteSet() {
        helper = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            helper.add(i);
        }
    }

    public int popSmallest() {
        return helper.poll();
    }

    public void addBack(int num) {
        if (helper.contains(num)) {
            return;
        }
        helper.add(num);
    }
}
