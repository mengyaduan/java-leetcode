package Lc.KrahetsInterview.DivideAndConquer;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/description/">翻转二叉树</a>
 **/
public class No226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

}
