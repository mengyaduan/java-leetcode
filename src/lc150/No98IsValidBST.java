package lc150;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No98IsValidBST {


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean a = isValidBST(root.left);
        boolean b = isValidBST(root.right);
        boolean c = true;
        if (root.left != null) {
            TreeNode item = root.left;
            while (item.right != null) {
                item = item.right;
            }
            c = item.val < root.val;
        }
        boolean d = true;
        if (root.right != null) {
            TreeNode item = root.right;
            while (item.left != null) {
                item = item.left;
            }
            d = item.val > root.val;
        }
        return a && b && c && d;
    }

}
