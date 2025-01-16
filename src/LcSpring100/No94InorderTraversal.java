package LcSpring100;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static DataStruct.tools.createTree;

public class No94InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    public void inorder(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        inorder(root.left, path);
        path.add(root.val);
        inorder(root.right, path);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,2,3,4,5,6,7");
        List<Integer> x = inorderTraversal(root);
        System.out.println(x);
    }
}
