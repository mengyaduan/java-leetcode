package Lc.KrahetsInterview.DivideAndConquer;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/symmetric-tree/description/">对称二叉树</a>
 **/
public class No101 {

    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        return isSymmetricTwo(left, right);
    }

    private boolean isSymmetricTwo(TreeNode leftNode, TreeNode rightNode) {
        // 任一为空，都不对
        if ((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null)) {
            return false;
        }
        if (leftNode == null && rightNode == null) {
            return true;
        }
        // 都不为空时，继续判断
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return isSymmetricTwo(leftNode.left, rightNode.right) && isSymmetricTwo(leftNode.right, rightNode.left);
    }


}

