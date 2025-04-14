package Lc119;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;

public class LCR054 {


    ArrayList<TreeNode> helper;

    public TreeNode convertBST(TreeNode root) {
        helper = new ArrayList<>();
        inorderTraverse(root);
        for (int i = helper.size() - 2; i >= 0; i--) {
            helper.get(i).val = helper.get(i + 1).val + helper.get(i).val;
        }
        return root;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        helper.add(root);
        inorderTraverse(root.right);
    }

}
