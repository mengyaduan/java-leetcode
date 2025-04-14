package Lc119;

import DataStruct.TreeNode;

import java.util.ArrayList;

/**
 * LCR 055
 */
public class BSTIterator {

    ArrayList<Integer> helper;
    int idx;

    public BSTIterator(TreeNode root) {
        idx = -1;
        helper = new ArrayList<>();
        inorderTraverse(root);
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        helper.add(root.val);
        inorderTraverse(root.right);
    }

    public int next() {
        return helper.get(++idx);
    }

    public boolean hasNext() {
        return idx < helper.size() - 1;
    }

}
