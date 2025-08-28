package LC100Again;


import DataStruct.TreeNode;
import javafx.scene.control.cell.CheckBoxListCell;
import org.testng.annotations.Test;

import java.util.HashMap;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

public class Lc047 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            helper.put(inorder[i], i);
        }
        return build(preorder, 0, inorder, 0, preorder.length - 1, helper);
    }

    private TreeNode build(int[] preorder, int rootIdx, int[] inorder, int l, int r, HashMap<Integer, Integer> helper) {
        if (l > r) {
            return null;
        }
        // 找到根节点
        TreeNode root = new TreeNode(preorder[rootIdx]);
        // 找到左子树的size和右子树的size
        int idx = helper.get(preorder[rootIdx]);
        int leftNum = idx - l;
        root.left = build(preorder, rootIdx + 1, inorder, l, idx - 1, helper);
        root.right = build(preorder, rootIdx + leftNum + 1, inorder, idx + 1, r, helper);
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
//        TreeNode root = createTree("3,9,20,null,null,15,7");
        printTree(buildTree(new int[]{3, 9, 8, 20, 15, 7}, new int[]{8, 9, 3, 15, 20, 7}));
        printTree(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        printTree(buildTree(new int[]{3}, new int[]{3}));

    }


}
