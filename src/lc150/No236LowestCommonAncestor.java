package lc150;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode x = lowestCommonAncestor(root.left, p, q);
        TreeNode y = lowestCommonAncestor(root.right, p, q);
        if (x != null && y != null) {
            return root;
        } else if (x == null) {
            return y;
        } else {
            return x;
        }
    }
}
