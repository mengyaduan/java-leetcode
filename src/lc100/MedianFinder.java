package lc100;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        averageTwoQ();
    }

    private void averageTwoQ() {
        while (minHeap.size() - maxHeap.size() > 1 || minHeap.size() - maxHeap.size() < 0) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return minHeap.peek() / 1.0;
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        m.addNum(-2);
        m.addNum(-3);
        System.out.println(m.findMedian());
    }

}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */