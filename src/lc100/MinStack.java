package lc100;

import DataStruct.DoubleListNode;

class MinStack {

    /**
     * key存节点的值，value存节点到尾部的最小值
     */
    DoubleListNode dummy;
    int minNow;

    public MinStack() {
        dummy = new DoubleListNode(-1, -1);
        minNow = Integer.MAX_VALUE;
    }

    public void push(int val) {
        minNow = Math.min(val, minNow);
        DoubleListNode item = new DoubleListNode(val, minNow);
        addToHead(item);
    }

    private void addToHead(DoubleListNode item) {
        item.next = dummy.next;
        dummy.next = item;
    }

    public void pop() {
        DoubleListNode item = dummy.next;
        dummy.next = item.next;
        if (item.key == minNow) {
            minNow = dummy.next == null ? Integer.MAX_VALUE : dummy.next.value;
        }
    }

    public int top() {
        return dummy.next.key;
    }

    public int getMin() {
        return dummy.next.value;
    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */