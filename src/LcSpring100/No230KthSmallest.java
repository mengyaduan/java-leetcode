package LcSpring100;

import DataStruct.TreeNode;

import java.util.ArrayList;

public class No230KthSmallest {
    ArrayList<Integer> inorderList;

    public int kthSmallest(TreeNode root, int k) {
        inorderList = new ArrayList<>();
        inorder(root);
        return inorderList.get(k - 1);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

}
