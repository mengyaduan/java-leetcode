package lc75;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=leetcode-75">二叉树的最大深度</a>
 */
public class No104_maxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("3,9,20,null,null,15,7");
        System.out.println(maxDepth(root));

    }
}
