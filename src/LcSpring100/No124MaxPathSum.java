package LcSpring100;

import DataStruct.TreeNode;

public class No124MaxPathSum {


    int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        traverse(root);
        return result;
    }

    /**
     * 返回以root为终点的路径长度，只可能从 root.val, func(root.left)+root.val, func(root.right)+root.val三个值中出现
     */
    private int traverse(TreeNode root) {
        if (root == null) {
            return -9999;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        // 计算结果
        int res = Math.max(root.val + left, root.val);
        res = Math.max(root.val + right, res);
        // 更新整体最大值，先比较root作为终点的结果，再比较root作为路径中间节点的结果
        result = Math.max(res, result);
        result = Math.max(result, left + right + root.val);
        return res;
    }


}
