package LC100Again;

import java.util.PriorityQueue;

/**
 * No 76
 */
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
        if (left.size() == right.size()) {
            // 左右相同，如果大于left最大的，则直接入right
            if (left.isEmpty() || num >= left.peek()) {
                right.add(num);
            } else {
                left.add(num);
                right.add(left.poll());
            }
        } else if (left.size() == right.size() - 1) {
            // 右边大于左边,根据右边的最小值决定
            if (num <= right.peek()) {
                left.add(num);
            } else {
                right.add(num);
                left.add(right.poll());
            }
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            if (left.isEmpty()) {
                return 0;
            }
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return right.peek();
        }
    }

}