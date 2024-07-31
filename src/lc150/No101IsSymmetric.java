package lc150;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No101IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null) {
            return true;
        }
        return p.val == q.val && symmetric(p.left, q.right) && symmetric(p.right, q.left);
    }
}
