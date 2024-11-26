package lc100;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> bigger;
    PriorityQueue<Integer> smaller;

    public MedianFinder() {
        bigger = new PriorityQueue<>();
        smaller = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (bigger.isEmpty() || num > bigger.peek()) {
            // 直接入大顶堆
            bigger.offer(num);
        } else {
            // 入大顶堆
            smaller.offer(num);
        }
        averageTwoQ(bigger, smaller);
    }

    private void averageTwoQ(PriorityQueue<Integer> bigger, PriorityQueue<Integer> smaller) {
        while (bigger.size() - smaller.size() > 1 || bigger.size() - smaller.size() < 0) {
            if (bigger.size() > smaller.size()) {
                smaller.offer(bigger.poll());
            } else {
                bigger.offer(smaller.poll());
            }
        }
    }

    public double findMedian() {
        if (bigger.size() == smaller.size()) {
            return (bigger.peek() + smaller.peek()) / 2.0;
        }
        return bigger.peek() / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        System.out.println(m.findMedian());
    }

}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */