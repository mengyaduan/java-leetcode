package lc75;

import DataStruct.TreeNode;


/**
 * @see <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75">二叉搜索数中的搜索</a>
 */
public class No700_searchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
