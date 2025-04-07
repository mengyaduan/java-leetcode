package Lc119;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static DataStruct.tools.createTree;

public class LCR049 {

    int result;

    public int sumNumbers(TreeNode root) {
        result = 0;
        dfs(root, new StringBuilder());
        return result;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(sb.toString());
        }
        if (root.left != null) {
            dfs(root.left, sb);
        }
        if (root.right != null) {
            dfs(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("4,9,0,5,1");
        System.out.println(sumNumbers(root));

    }

}
