package Lc.KrahetsInterview.DivideAndConquer;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.Arrays;

import static DataStruct.BinaryTreePrinter.printTree;

/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">根据前序遍历和中序遍历构造二叉树</a>
 **/
public class No105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        // 定位root，划分左右子集
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndexAtInorder = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndexAtInorder = i;
                break;
            }
        }
        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndexAtInorder + 1);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndexAtInorder);
        int[] preRight = Arrays.copyOfRange(preorder, rootIndexAtInorder + 1, preorder.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndexAtInorder + 1, inorder.length);

        root.left = buildTree(preLeft, inorderLeft);
        root.right = buildTree(preRight, inorderRight);

        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        root = buildTree(new int[]{1, 2}, new int[]{2, 1});

        printTree(root);

    }

}

