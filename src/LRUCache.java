import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yameng.dym
 * @see <a href="https://leetcode.com/problems/lru-cache/description/?spm=ata.21736010.0.0.331c605f2teuuY">no146</a>
 **/
public class LRUCache {
    private int cap = 0;
    Map<Integer, DoubleListNode> nodeMap = new HashMap<>();
    LinkedList<DoubleListNode> lRUList = new LinkedList<>();


    DoubleListNode head = new DoubleListNode(0, 0);
    DoubleListNode tail = new DoubleListNode(0, 0);


    public LRUCache(int capacity) {
        this.cap = capacity;
        head.pre = null;
        head.next = tail;
        tail.next = null;
        tail.pre = head;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        DoubleListNode target = nodeMap.get(key);
        DoubleListNode newOne = moveToHead(target);
        nodeMap.put(key, newOne);
        return target.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            DoubleListNode target = nodeMap.get(key);
            target.value = value;
            DoubleListNode newOne = moveToHead(target);
            nodeMap.put(key, newOne);
            return;
        }
        if (nodeMap.size() < cap) {
            DoubleListNode target = new DoubleListNode(key, value);
            addHead(target);
            nodeMap.put(key, target);
        } else {
            DoubleListNode target = new DoubleListNode(key, value);
            addHead(target);
            nodeMap.put(key, target);
            int keyPop = popTail();
            nodeMap.remove(keyPop);
        }
    }

    public void addHead(DoubleListNode target) {
        target.pre = head;
        target.next = head.next;
        head.next.pre = target;
        head.next = target;
    }

    public DoubleListNode moveToHead(DoubleListNode target) {
        DoubleListNode tmp = new DoubleListNode(target.key, target.value);
        addHead(tmp);
        remove(target);
        return tmp;
    }

    public int remove(DoubleListNode target) {
        DoubleListNode pre = target.pre;
        pre.next = target.next;
        target.next.pre = pre;
        target.next = null;
        target.pre = null;
        return target.value;
    }

    public int popTail() {
        DoubleListNode res = tail.pre;
        remove(res);
        return res.key;
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
        next = null;
    }


}
