package Lc.search;

import Lc.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">no145 后序遍历-左右根</a>
 **/
public class No145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }


    @Test(description = "单测")
    public void test() throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal(root));
        System.out.println(postorderTraversal(null));
        System.out.println(postorderTraversal(new TreeNode(1)));
    }


}
