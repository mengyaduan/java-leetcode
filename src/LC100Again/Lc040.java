package LC100Again;


import DataStruct.TreeNode;

public class Lc040 {

    int nodeMax;

    public int diameterOfBinaryTree(TreeNode root) {
        nodeMax = 0;
        traversal(root);
        return nodeMax - 1;
    }

    private int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = traversal(root.left);
        int rightNodes = traversal(root.right);
        nodeMax = Math.max(nodeMax, leftNodes + rightNodes + 1);
        return Math.max(leftNodes, rightNodes) + 1;
    }

}
