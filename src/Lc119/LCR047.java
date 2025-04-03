package Lc119;

import DataStruct.TreeNode;

public class LCR047 {


    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null) {
            return root.val == 0 ? null : root;
        } else {
            return root;
        }
    }

}
