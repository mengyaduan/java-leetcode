package Lc.dynamicprogramming;

import Lc.TreeNode;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/house-robber-iii/">打家劫舍 iii</a>
 **/
public class No337 {


    HashMap<TreeNode, Integer> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return dp(root);
    }


    /**
     * 走到第i个房子后，能获取的最大收益
     *
     * @return
     */
    public int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 选择根节点
        int pickRoot = root.val;
        if (root.left != null && root.left.left != null) {
            pickRoot += dp(root.left.left);
        }
        if (root.left != null && root.left.right != null) {
            pickRoot += dp(root.left.right);
        }
        if (root.right != null && root.right.left != null) {
            pickRoot += dp(root.right.left);
        }
        if (root.right != null && root.right.right != null) {
            pickRoot += dp(root.right.right);
        }
        // 不选择根节点
        int notPickRoot = 0;
        if (root.left != null) {
            notPickRoot += dp(root.left);
        }
        if (root.right != null) {
            notPickRoot += dp(root.right);
        }
        memo.put(root, Math.max(pickRoot, notPickRoot));
        return memo.get(root);
    }


    @Test(description = "单测")
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(5);
        root.left = a1;
        root.right = a2;

        a1.left = new TreeNode(1);
        a1.right = new TreeNode(3);
        a2.right = new TreeNode(1);

        int x = rob(a1);
        System.out.println(x);
    }

}
