package Lc.KrahetsInterview.StackAndQueue;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/find-median-from-data-stream/description/">数据流的中位数</a>
 **/
public class No295 {
    /**
     * 维护两个栈，左栈右栈，左栈从小到大入栈，右栈从大到小入栈
     * <p>如果两栈大小相同，中位数就是两个栈顶相加除以2</p>
     * <p>如果左栈-右栈=1，则中位数是左栈栈顶</p>
     * <p>不存在右栈大于左栈的情况</p>
     * <p>入栈时，需要判断当前数据与左栈右栈的栈顶大小，决定是入左还是入右，同时需要维护两个栈的平衡</p>
     **/

    @Test(description = "")
    public void test() throws Exception {
        String[] opt = {"MedianFinder", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"};
        String[] optNum = {null, "1", null, "2", null, "3", null, "4", null, "5", null, "6", null, "7", null, "8", null, "9", null, "10", null};
        MedianFinder mf = null;
        for (int i = 0; i < opt.length; i++) {
            if (opt[i].equals("MedianFinder")) {
                mf = new MedianFinder();
            }
            if (opt[i].equals("addNum")) {
                mf.addNum(Integer.parseInt(optNum[i]));
                System.out.println(mf);
            }
            if (opt[i].equals("findMedian")) {
                System.out.println(mf.findMedian());
            }
        }
    }


}

class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        // 大顶堆
        left = new PriorityQueue<>((a, b) -> b - a);
        // 小顶堆
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 如果左或右栈为空，或者num比左栈顶小，入左栈
        if (left.isEmpty() || right.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }
        while (left.size() < right.size() + 1) {
            left.add(right.poll());
        }
        while (left.size() > right.size() + 1) {
            right.add(left.poll());
        }
    }

    public double findMedian() {
        if (left.isEmpty()) {
            return 0.0000;
        }
        if (right.isEmpty()) {
            return left.peek();
        }
        if (left.size() == right.size() + 1) {
            return left.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0000;
        }
    }

    @Override
    public String toString() {
        return StringUtils.join(left, ",") + " → " + StringUtils.join(right, ",");
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

