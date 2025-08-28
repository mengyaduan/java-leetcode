package LC100Again;


import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

public class Lc046 {

    public void flatten(TreeNode root) {
        flat(root);
    }

    public TreeNode flat(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode itemLeft = flat(root.left);
        TreeNode itemRight = flat(root.right);
        if (itemLeft != null) {
            root.left = null;
            root.right = itemLeft;
            TreeNode cur = itemLeft;
            while (cur != null && cur.right != null) {
                cur = cur.right;
            }
            cur.right = itemRight;
        }
        return root;
    }


    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,null,3");
        flatten(root);
        printTree(root);

    }


}
