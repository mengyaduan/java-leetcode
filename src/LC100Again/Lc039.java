package LC100Again;


import DataStruct.TreeNode;

public class Lc039 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric2(root.left, root.right);
    }

    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && isSymmetric2(left.right, right.left) && isSymmetric2(left.left, right.right);
        }
    }


}
