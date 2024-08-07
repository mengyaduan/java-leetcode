package lc150;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No530GetMinimumDifference {

    int ans;
    int pre;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        inorderTraverse(root);
        return ans;
    }

    public void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        if (pre != -1) {
            ans = Math.min(ans, Math.abs(root.val - pre));
        }
        pre = root.val;
        inorderTraverse(root.right);
    }

}
