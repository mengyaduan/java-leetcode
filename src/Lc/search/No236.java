package Lc.search;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">no236 二叉树的最近公共祖先</a>
 **/
public class No236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = new TreeNode(1);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(2);
        root.left = p;
        root.right = q;
        root.right.left = new TreeNode(3);

        TreeNode x = lowestCommonAncestor(root, root.right, root.right.left);
        System.out.println(x.val);


    }


}
