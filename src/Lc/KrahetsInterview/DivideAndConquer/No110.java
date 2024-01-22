package Lc.KrahetsInterview.DivideAndConquer;

import DataStruct.TreeNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/description/">平衡二叉树</a>
 **/
public class No110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        int heightLeft = getHeight(root.left);
        int heightRight = getHeight(root.right);
        System.out.println("左子树高：" + heightLeft);
        System.out.println("右子树高：" + heightRight);
        int diff = heightRight - heightLeft;
        diff = diff < 0 ? -diff : diff;
        return diff <= 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                //
                {"3,9,20,null,null,15,7", true},
                {"1,2,2,3,3,null,null,4,4", false},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(String tr, boolean expected) throws Exception {
        TreeNode root = createTree(tr);
        Assert.assertEquals(isBalanced(root), expected);

    }
}

