package LcSecond.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/">填充每个节点的右侧指针</a>
 **/
public class No116_PopulatingNextRightPointer {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node pre = null;
        Deque<Node> helper = new ArrayDeque<>();
        helper.add(root);
        // 层序遍历，每层都指向下一个
        while (!helper.isEmpty()) {
            int layerCount = helper.size();
            pre = null;
            while (layerCount > 0) {
                Node item = helper.pollFirst();
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

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};