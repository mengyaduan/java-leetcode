package Lc.KrahetsInterview.BackTrack;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">树的深度</a>
 **/
public class No104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}

