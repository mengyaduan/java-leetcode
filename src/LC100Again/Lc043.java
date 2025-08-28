package LC100Again;


import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

public class Lc043 {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("3,2,4,1,null,null,5");
        System.out.println(isValidBST(root));
        root = createTree("3,2,4,1,null,5");
        System.out.println(isValidBST(root));
        root = createTree("3,2,5,1,null,4");
        System.out.println(isValidBST(root));


    }


}
