package Lc119;

import DataStruct.DoubleListNode;
import DataStruct.ListNode;

import java.util.HashMap;

/**
 * LRC 031
 */
public class LRUCache {

    int capacity;
    DoubleListNode dummy;
    DoubleListNode tail;
    HashMap<Integer, DoubleListNode> helper;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new DoubleListNode(-1, -1);
        helper = new HashMap<>();
    }

    public int get(int key) {
        if (!helper.containsKey(key)) {
            return -1;
        }
        // 如果存在，则将其前移到最前面
        move2Head(helper.get(key));
        return helper.get(key).value;
    }

    public void put(int key, int value) {
        if (helper.containsKey(key)) {
            // 已有了，直接更新值
            helper.get(key).value = value;
            move2Head(helper.get(key));
            return;
        }
        // 如果没有，判断capacity
        DoubleListNode item = new DoubleListNode(key, value);
        if (helper.size() == this.capacity) {
            removeTail();
        }
        insertHead(item);
        helper.put(key, item);
    }

    private void insertHead(DoubleListNode item) {
        item.next = dummy.next;
        if (dummy.next != null) {
            dummy.next.pre = item;
        } else {
            tail = item;
        }
        dummy.next = item;
        item.pre = dummy;
    }

    private void removeTail() {
        if (tail == dummy) {
            return;
        }
        helper.remove(tail.key);
        tail = tail.pre;
        tail.next = null;
    }


    private void move2Head(DoubleListNode target) {
        if (target.next != null) {
            target.next.pre = target.pre;
            target.pre.next = target.next;
        } else {
            tail = target.pre;
            tail.next = null;
            target.pre = null;
        }
        insertHead(target);
    }

}
