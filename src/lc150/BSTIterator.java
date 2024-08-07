package lc150;

import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.cn/problems/binary-search-tree-iterator/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class BSTIterator {

    ArrayList<Integer> helper;
    int idx = -1;

    public BSTIterator(TreeNode root) {
        helper = new ArrayList<>();
        inorder(root);
        idx = 0;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        helper.add(root.val);
        inorder(root.right);
    }


    public int next() {
        int x = helper.get(idx);
        idx++;
        return x;
    }

    public boolean hasNext() {
        return idx < helper.size();
    }

}
