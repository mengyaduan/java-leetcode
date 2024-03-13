package Lc.dfs;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/symmetric-tree/description/"></a>
 **/
public class No101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return symTwo(root.left, root.right);
    }

    public boolean symTwo(TreeNode left, TreeNode right) {
        boolean leftN = left == null;
        boolean rightN = right == null;
        if ((leftN && !rightN) || (!leftN && rightN)) {
            return false;
        }
        if (leftN) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return symTwo(left.right, right.left) && symTwo(left.left, right.right);
    }
}

