package Lc.search;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">no144 前序遍历-根左右</a>
 **/
public class No144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        if (node.left != null) {
            dfs(node.left, res);
        }
        if (node.right != null) {
            dfs(node.right, res);
        }
        if (node.left == null && node.right == null) {
            return;
        }
    }


    @Test(description = "单测")
    public void test() throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal(null));
        System.out.println(preorderTraversal(new TreeNode(1)));
    }


}
