package lc150;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class LRUCache {

    HashMap<Integer, DoubleListNode> nodeAddr;
    // 存储虚拟头结点，实际是最早用到的
    DoubleListNode dummyHead;
    // 存储最新的节点
    DoubleListNode latestNode;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeAddr = new HashMap<>();
        dummyHead = new DoubleListNode(-1, -1);
        latestNode = dummyHead;
    }

    public int get(int key) {
        if (!nodeAddr.containsKey(key)) {
            return -1;
        }
        put(key, nodeAddr.get(key).value);
        return nodeAddr.get(key).value;
    }

    public void put(int key, int value) {
        if (nodeAddr.containsKey(key)) {
            // 已经有了，不需要考虑容量问题，将已有节点挪到最新节点处，成为最新节点
            DoubleListNode item = nodeAddr.get(key);
            if (item == latestNode) {
                item.value = value;
                return;
            }
            item.pre.next = item.next;
            item.next.pre = item.pre;
            latestNode.next = item;
            item.pre = latestNode;
            latestNode = latestNode.next;
            item.next = null;
            item.value = value;
            return;
        }
        // 然后是新增
        if (nodeAddr.size() >= capacity) {
            // 删除dummyHead后面的，插入新的，记得更新map
            DoubleListNode itemRemoved = dummyHead.next;
            if (itemRemoved == latestNode) {
                latestNode = latestNode.pre;
                latestNode.next = null;
            } else {
                itemRemoved.pre.next = itemRemoved.next;
                itemRemoved.next.pre = itemRemoved.pre;
            }
            int keyRemoved = itemRemoved.key;
            nodeAddr.remove(keyRemoved);
        }
        // 插入：直接插入到最新节点后面，成为最新
        DoubleListNode item = new DoubleListNode(key, value, latestNode, null);
        latestNode.next = item;
        latestNode = latestNode.next;
        nodeAddr.put(key, item);
    }
}

class DoubleListNode {
    public DoubleListNode next;
    public DoubleListNode pre;
    public int key;
    public int value;

    public DoubleListNode(int x, int y) {
        key = x;
        value = y;
        this.next = null;
        this.pre = null;
    }

    public DoubleListNode(int x, int y, DoubleListNode pre, DoubleListNode next) {
        key = x;
        value = y;
        this.next = next;
        this.pre = pre;
    }

}



