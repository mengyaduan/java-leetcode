package lc100;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;
import static DataStruct.tools.printIntArray;

public class No94 {

    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        result.add(root.val);
        traversal(root.right);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,null,2,null,null,3");
        System.out.println(inorderTraversal(root));

    }


}
