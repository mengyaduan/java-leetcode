package LcSecond.dfs;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/description/">是否平衡二叉树</a>
 **/
public class No110_BalancedBT {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

