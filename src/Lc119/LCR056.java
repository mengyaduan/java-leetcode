package Lc119;

import DataStruct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LCR056 {

    HashSet<Integer> helper;

    public boolean findTarget(TreeNode root, int k) {
        helper = new HashSet<>();
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (helper.contains(k - root.val)) {
            return true;
        }
        helper.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }
}
