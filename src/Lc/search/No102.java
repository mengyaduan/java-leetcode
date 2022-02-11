package Lc.search;

import Lc.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">no102 层序遍历</a>
 **/
public class No102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levelOrderWithQueue(res, queue);
        return res;
    }


    public void levelOrderWithQueue(List<List<Integer>> res, Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            return;
        }
        List<Integer> tmp = new ArrayList<>();
        int count = queue.size();
        while (count > 0) {
            TreeNode x = queue.remove();
            if (x == null) {
                return;
            }
            tmp.add(x.val);
            if (x.left != null) {
                queue.add(x.left);
            }
            if (x.right != null) {
                queue.add(x.right);
            }
            count--;
        }
        res.add(tmp);
        levelOrderWithQueue(res, queue);
    }


    @Test(description = "单测")
    public void test() throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
        System.out.println(levelOrder(null));
        System.out.println(levelOrder(new TreeNode(1)));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        System.out.println(levelOrder(root2));
    }


}
