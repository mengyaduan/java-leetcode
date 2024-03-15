package LcSecond.dfs;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/">二叉树展开为链表</a>
 **/
public class No114_FlattenBinaryTreeToLinkedList {

    TreeNode pre = null;

    public void flatten(TreeNode root) {
        preOrder(root);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        if (pre == null) {
            pre = root;
        } else {
            pre.right = root;
            pre = pre.right;
        }
        preOrder(tempLeft);
        preOrder(tempRight);
        root.left = null;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,2,5,3,4,null,6");
//        preOrder(root);
        flatten(root);
        printTree(root);
    }
}

