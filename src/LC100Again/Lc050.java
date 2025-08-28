package LC100Again;


import DataStruct.TreeNode;

public class Lc050 {

    int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        traversal(root);
        return result;
    }

    private int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSide = traversal(root.left);
        int rightSide = traversal(root.right);
        // 贯穿root节点时的最长
        result = Math.max(result, leftSide + rightSide + root.val);
        // 仅含单边+root节点时的最长
        int single = Math.max(leftSide, rightSide) + root.val;
        result = Math.max(result, single);
        // 双边都不含
        result = Math.max(result, root.val);
        return single;
    }

}
