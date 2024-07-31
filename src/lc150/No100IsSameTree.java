package lc150;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.cn/problems/same-tree/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No100IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
