package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.HashMap;

import static DataStruct.BinaryTreePrinter.printTree;

/**
 * @see <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No106BuildTree {

    HashMap<Integer, Integer> idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        idx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idx.put(inorder[i], i);
        }
        // [左，右)
        return buildTreeIdx(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTreeIdx(int[] inorder, int i, int j, int[] postorder, int x, int y) {
        if (j - i < 1) {
            return null;
        }
        if (j - i == 1) {
            return new TreeNode(inorder[i]);
        }
        TreeNode root = new TreeNode(postorder[y - 1]);
        int idxOfRoot = idx.get(root.val);
        int leftSize = idxOfRoot - i;
        root.left = buildTreeIdx(inorder, i, idxOfRoot, postorder, x, x + leftSize);
        root.right = buildTreeIdx(inorder, idxOfRoot + 1, j, postorder, x + leftSize, y - 1);
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 2, 1});

        printTree(root);

    }

}
