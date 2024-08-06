package lc150;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No117Connect {

    public dNode connect(dNode root) {
        if (root == null) {
            return null;
        }
        Deque<dNode> helper = new ArrayDeque<>();
        helper.push(root);
        while (!helper.isEmpty()) {
            int sizeLayer = helper.size();
            dNode pre = null;
            for (int i = 0; i < sizeLayer; i++) {
                dNode item = helper.pollFirst();
                System.out.print(item.val + "-");
                if (item.left != null) {
                    helper.addLast(item.left);
                }
                if (item.right != null) {
                    helper.addLast(item.right);
                }
                if (pre != null) {
                    pre.next = item;
                }
                pre = item;
            }
            System.out.println("一层结束");
        }
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        dNode root = new dNode(1);
        dNode n2 = new dNode(2);
        dNode n3 = new dNode(3);
        dNode n4 = new dNode(4);
        dNode n5 = new dNode(5);
        dNode n7 = new dNode(7);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;
        dNode x = connect(root);
        System.out.println(x);

    }
}


class dNode {
    public int val;
    public dNode left;
    public dNode right;
    public dNode next;

    public dNode() {
    }

    public dNode(int _val) {
        val = _val;
    }

    public dNode(int _val, dNode _left, dNode _right, dNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};