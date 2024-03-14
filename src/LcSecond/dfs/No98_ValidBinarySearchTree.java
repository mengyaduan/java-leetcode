package LcSecond.dfs;

import DataStruct.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">验证二叉搜索树</a>
 **/
public class No98_ValidBinarySearchTree {

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(isValidBST(createTree("32,26,47,19,null,null,56,null,27")), false);
        pre = null;
        Assert.assertEquals(isValidBST(createTree("5,4,6,null,null,3,7")), false);
        pre = null;
        Assert.assertEquals(isValidBST(createTree("2,1,3")), true);
        pre = null;
        Assert.assertEquals(isValidBST(createTree("2147483647")), true);
        pre = null;
        Assert.assertEquals(isValidBST(createTree("2147483647,2147483647")), false);
        pre = null;
        Assert.assertEquals(isValidBST(createTree("2147483647,null,2147483647")), false);

    }
}

