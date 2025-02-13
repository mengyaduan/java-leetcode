package LcSpring100;

import DataStruct.TreeNode;

public class No236LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        return root;
    }
}
