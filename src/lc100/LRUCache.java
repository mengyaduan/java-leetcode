package lc100;

import DataStruct.DoubleListNode;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer, DoubleListNode> helper;
    DoubleListNode headPre;
    DoubleListNode tail;
    int cap;

    public LRUCache(int capacity) {
        helper = new HashMap<>();
        headPre = new DoubleListNode(0, 0);
        tail = headPre;
        cap = capacity;
    }

    public int get(int key) {
        int result = -1;
        if (!helper.containsKey(key)) {
            return result;
        }
        DoubleListNode target = helper.get(key);
        result = target.value;
        moveToHead(target);
        return result;
    }

    public void put(int key, int value) {
        // 如果已经存在，则更新值，调整位置
        if (helper.containsKey(key)) {
            DoubleListNode target = helper.get(key);
            target.value = value;
            moveToHead(target);
            return;
        }
        // 如果不存在，判断当前大小
        if (helper.size() < cap) {
            // 未溢出
            DoubleListNode target = new DoubleListNode(key, value);
            helper.put(key, target);
            addToHead(target);
            return;
        }
        // 溢出，移除tail，重新添加
        DoubleListNode toBeRemoved = tail;
        tail = tail.pre;
        tail.next = null;
        helper.remove(toBeRemoved.key);
        put(key, value);
    }

    public void addToHead(DoubleListNode target) {
        target.next = headPre.next;
        if (headPre.next != null) {
            headPre.next.pre = target;
        }
        headPre.next = target;
        target.pre = headPre;
        if (tail == headPre) {
            // 如果没给尾指针赋过值
            tail = target;
        }
    }

    public void moveToHead(DoubleListNode target) {
        // 将target取出来，如果target是tail，需要更新！
        if (target == tail) {
            tail = target.pre;
            tail.next = null;
        } else {
            target.pre.next = target.next;
            target.next.pre = target.pre;
        }
        addToHead(target);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */