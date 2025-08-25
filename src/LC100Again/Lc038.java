package LC100Again;


import DataStruct.TreeNode;

public class Lc038 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode item = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(item);
        return root;
    }

}
