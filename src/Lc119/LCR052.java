package Lc119;

import DataStruct.TreeNode;

public class LCR052 {

    TreeNode result;
    TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        result = new TreeNode(-1);
        cur = result;
        dfs(root);
        return result.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        dfs(left);
        cur.right = root;
        cur = cur.right;
        dfs(right);
    }

}
