package Lc119;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

public class LCR051 {

    int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 左边单边
        int leftSingle = Math.max(left, 0) + root.val;
        // 右边单边
        int rightSingle = Math.max(right, 0) + root.val;
        result = Math.max(result, leftSingle);
        result = Math.max(result, rightSingle);
//        int tmp = Math.max(root.val, left + right + root.val);
//        result = Math.max(result, tmp);
        result = Math.max(result, leftSingle + rightSingle - root.val);
        return Math.max(leftSingle, rightSingle);
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxPathSum(createTree("1,2,3")));

    }

}
