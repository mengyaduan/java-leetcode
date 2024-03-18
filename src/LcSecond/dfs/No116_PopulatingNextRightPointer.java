package LcSecond.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/">填充每个节点的右侧指针</a>
 **/
public class No116_PopulatingNextRightPointer {

    public NodeR connect(NodeR root) {
        if (root == null) {
            return root;
        }
        NodeR pre = null;
        Deque<NodeR> helper = new ArrayDeque<>();
        helper.add(root);
        // 层序遍历，每层都指向下一个
        while (!helper.isEmpty()) {
            int layerCount = helper.size();
            pre = null;
            while (layerCount > 0) {
                NodeR item = helper.pollFirst();
                layerCount--;
                if (pre == null) {
                    pre = item;
                } else {
                    pre.next = item;
                    pre = item;
                }
                if (item.left != null) {
                    helper.add(item.left);
                }
                if (item.right != null) {
                    helper.add(item.right);
                }
            }
            pre.next = null;
        }
        return root;
    }

}

class NodeR {
    public int val;
    public NodeR left;
    public NodeR right;
    public NodeR next;

    public NodeR() {
    }

    public NodeR(int _val) {
        val = _val;
    }

    public NodeR(int _val, NodeR _left, NodeR _right, NodeR _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};