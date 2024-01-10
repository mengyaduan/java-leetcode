package Lc.search;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">no94 中序遍历-左根右</a>
 **/
public class No94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }


    @Test(description = "单测")
    public void test() throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal(null));
        System.out.println(inorderTraversal(new TreeNode(1)));
    }


}
