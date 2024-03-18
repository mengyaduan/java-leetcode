package LcSecond.dfs;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/description/">二叉树最大路径和</a>
 **/
public class No124_MaxPathSumOfBT {

    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPs(root);
        return res;
    }

    public int maxPs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSide = maxPs(root.left);
        int rightSide = maxPs(root.right);
        int singleBranch = root.val + Math.max(leftSide, rightSide);
        // singleBranch也包括两个子分支都不要的情况
        singleBranch = Math.max(root.val, singleBranch);
        int doubleBranches = root.val + leftSide + rightSide;
        res = Math.max(res, Math.max(singleBranch, doubleBranches));
        return singleBranch;
    }


    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("2,-1,-2");
        System.out.println(maxPathSum(root));

    }
}
