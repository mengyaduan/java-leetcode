package Lc.search;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">No104 Maximum Depth of Binary Tree</a>
 **/
public class No104 {
    int res = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }


    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }


    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = new TreeNode(1);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(2);
        root.left = p;
        root.right = q;
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(3);

        int x = maxDepth(root);
        System.out.println(x);


    }
}
