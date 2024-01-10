package Lc.search;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">二叉树的直径</a>
 **/
public class No543 {
    int diameter = 0;


    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        int tmpDiameter = leftLen + rightLen;
        diameter = Math.max(tmpDiameter, diameter);

        return Math.max(leftLen, rightLen) + 1;
    }


    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int x = diameterOfBinaryTree(root);
        System.out.println(x);

    }
}
