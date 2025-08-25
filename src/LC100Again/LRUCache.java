package LC100Again;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.testng.annotations.Test;

import java.util.HashMap;


/**
 * 035
 */
public class LRUCache {


    int capacity;
    HashMap<Integer, DoubleListNode> helper;
    DoubleListNode dummy;
    DoubleListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        helper = new HashMap<>();
        dummy = new DoubleListNode(-1, -1);
        tail = new DoubleListNode(-1, -1);
        dummy.next = tail;
        tail.pre = dummy;
    }

    public int get(int key) {
        if (!helper.containsKey(key)) {
            return -1;
        }
        int res = helper.get(key).value;
        move2Head(helper.get(key));
        return res;
    }

    private void move2Head(DoubleListNode item) {
        item.pre.next = item.next;
        item.next.pre = item.pre;
        item.next = dummy.next;
        dummy.next.pre = item;
        dummy.next = item;
        item.pre = dummy;
    }

    public void put(int key, int value) {
        if (helper.containsKey(key)) {
            // 已经存在，只需要更新就好了
            helper.get(key).value = value;
            move2Head(helper.get(key));
            return;
        }
        if (helper.size() >= this.capacity) {
            // 不存在且容量已满
            DoubleListNode toRemove = tail.pre;
            toRemove.pre.next = toRemove.next;
            toRemove.next.pre = toRemove.pre;
            helper.remove(toRemove.key);
        }
        // 不存在且容量足够
        DoubleListNode item = new DoubleListNode(key, value);
        helper.put(key, item);
        add2Head(item);
    }

    private void add2Head(DoubleListNode item) {
        item.next = dummy.next;
        item.next.pre = item;
        dummy.next = item;
        item.pre = dummy;
    }

    class DoubleListNode {
        int key;
        int value;
        DoubleListNode next;
        DoubleListNode pre;

        DoubleListNode(int k, int v) {
            this.key = k;
            this.value = v;
            this.next = null;
            this.pre = null;
        }

    }


}
