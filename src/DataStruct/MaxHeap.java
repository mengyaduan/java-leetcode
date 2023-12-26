package DataStruct;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 实现一个大顶堆
 */
public class MaxHeap {

    ArrayList<Integer> heap;

    public MaxHeap(int... val) {
        heap = Arrays.stream(val)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public int peek() {
        return heap.get(0);
    }

    public void push(int val) {
        // 追加到尾部，然后自底向上堆化
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    public void siftUp(int i) {
        while (true) {
            int parentIndex = parent(i);
            if (parentIndex < 0 || heap.get(i) <= heap.get(parentIndex)) {
                break;
            } else {
                swap(parentIndex, i);
            }
            i = parentIndex;
        }

    }

    public int pop() {
        if (heap.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        // 将第一个和最后一个交换，弹出后，自顶向下堆化
        swap(0, heap.size() - 1);
        int lastOne = heap.remove(heap.size() - 1);
        siftDown(0);
        return lastOne;
    }

    public void siftDown(int i) {
        while (true) {
            int leftIndex = left(i);
            int rightIndex = right(i);
            int maxIndex = i;
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }
            if (maxIndex == i) {
                // 已经不需要交换了，意味着堆化完成
                break;
            }
            // 交换i和max
            swap(i, maxIndex);
            i = maxIndex;

        }

    }

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }


    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    @Override
    public String toString() {
        return StringUtils.join(heap, ", ");
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(9, 8, 6, 6, 7, 5, 2, 1, 4, 3, 6, 2);
        System.out.println(maxHeap);
        maxHeap.push(7);
        System.out.println(maxHeap);
        System.out.println("弹出首个: " + maxHeap.pop());
        System.out.println(maxHeap);
    }


}
