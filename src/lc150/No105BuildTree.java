package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No105BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder找到root，然后根据inorder拆分左右，继续
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int size = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            size++;
        }
        int[] preorderLeft = new int[size];
        int[] inorderLeft = new int[size];
        int[] preorderRight = new int[preorder.length - 1 - size];
        int[] inorderRight = new int[preorder.length - 1 - size];

        for (int i = 0; i < size; i++) {
            preorderLeft[i] = preorder[i + 1];
            inorderLeft[i] = inorder[i];
        }
        for (int i = 0; i < preorder.length - 1 - size; i++) {
            preorderRight[i] = preorder[i + 1 + size];
            inorderRight[i] = inorder[i + 1 + size];
        }
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));

    }

}
