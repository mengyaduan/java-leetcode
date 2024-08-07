package lc150;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No138CopyRandomList {

    public NodeRandom copyRandomList(NodeRandom head) {
        NodeRandom pivot = head;
        NodeRandom preHead = new NodeRandom(-1);
        NodeRandom cur = preHead;
        HashMap<NodeRandom, Integer> origin = new HashMap<>();
        HashMap<Integer, NodeRandom> helper = new HashMap<>();
        // 循环一次，加入map
        int idx = 0;
        while (pivot != null) {
            // 将原始的数据进行编号
            origin.put(pivot, idx);
            NodeRandom item = new NodeRandom(pivot.val);
            // 将新增的进行编号
            helper.put(idx, item);
            cur.next = item;
            cur = cur.next;
            pivot = pivot.next;
            idx++;
        }
        // 再循环一次，关联随机数
        pivot = head;
        cur = preHead.next;
        while (pivot != null) {
            // 获取随机数再原始序列中的编号
            if (pivot.random != null) {
                int originIdx = origin.get(pivot.random);
                cur.random = helper.get(originIdx);
            }
            pivot = pivot.next;
            cur = cur.next;
        }
        return preHead.next;
    }

}

class NodeRandom {
    int val;
    NodeRandom next;
    NodeRandom random;

    public NodeRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
