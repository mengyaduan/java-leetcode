package LcSecond.linkedList;

import DataStruct.DoubleListNode;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/description/">LRU 缓存</a>
 **/
public class LRUCache {
    /**
     * 存储节点的位置
     */
    HashMap<Integer, DoubleListNode> map;

    int capacity;

    DoubleListNode head;
    DoubleListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleListNode item = map.get(key);
        put(key, item.value);
        return item.value;
    }

    public void put(int key, int value) {
        // 如果链表是空的，初始化队列
        if (head == null) {
            DoubleListNode item = new DoubleListNode(key, value);
            head = item;
            tail = head;
            if (map.size() < capacity) {
                map.put(key, item);
            }
        }
        // 如果链表有值，区分当前key是否在链表中，如果在，直接更新即可
        if (map.containsKey(key)) {
            DoubleListNode item = map.get(key);
            item.value = value;
            if (item == head) {
                // 如果已经是头部了，则只需要更新值
                return;
            }
            if (tail == item) {
                // 如果是尾部，需要更新尾指针
                tail = item.pre;
            }
            if (item.pre != null) {
                item.pre.next = item.next;
            }
            if (item.next != null) {
                item.next.pre = item.pre;
            }
            // 取出item节点，将其置成head
            item.pre = null;
            item.next = head;
            head.pre = item;
            head = item;
        } else {
            DoubleListNode item = new DoubleListNode(key, value);
            item.next = head;
            head.pre = item;
            head = item;
            map.put(key, item);
            if (map.size() > capacity) {
                // 新增kv，需要踢掉尾指针
                DoubleListNode toBeRemoved = tail;
                tail = tail.pre;
                tail.next = null;
                map.remove(toBeRemoved.key);
            }
        }
    }

}

