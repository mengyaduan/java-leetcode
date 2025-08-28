package LC100Again;


import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static DataStruct.tools.createTree;

public class Lc044 {


    int cnt;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        cnt = 0;
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || cnt >= k) return;
        inorder(root.left, k);
        if (++cnt == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("3,1,4,null,2");
        System.out.println(kthSmallest(root, 1));

    }

}
