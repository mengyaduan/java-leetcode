package lc100;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

public class TreeProblems_2 {

    /**
     * 226
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    @Test(description = "")
    public void testInvertTree() throws Exception {
        TreeNode root = createTree("1,2,3,4,5,6,7,8");
        printTree(invertTree(root));
    }

    /**
     * 101
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTwo(root.left, root.right);
    }

    public boolean isSymmetricTwo(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 != null && r2 != null) {
            return r1.val == r2.val && isSymmetricTwo(r1.left, r2.right) && isSymmetricTwo(r1.right, r2.left);
        } else {
            return false;
        }
    }


}
