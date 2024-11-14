package lc100;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

public class No104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,2,3,4,5,6,7,8");
        System.out.println(maxDepth(root));

    }
}
