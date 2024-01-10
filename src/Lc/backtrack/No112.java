package Lc.backtrack;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/path-sum/?show=1">no112 计算路径总和</a>
 */
public class No112 {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return backtrack(root, 0, targetSum);
    }


    public boolean backtrack(TreeNode cur, int sumNow, int targetSum) {
        // 结束条件及操作
        if (cur.left == null && cur.right == null) {
            sumNow += cur.val;
            if (sumNow == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        // 加入路径，从选择列表中删除
        sumNow = sumNow + cur.val;


        // nextLevel
        if (cur.left != null) {
            boolean tmp = backtrack(cur.left, sumNow, targetSum);
            if (tmp) {
                return true;
            }
        }
        if (cur.right != null) {
            boolean tmp = backtrack(cur.right, sumNow, targetSum);
            if (tmp) {
                return true;
            }
        }
        // 从路径中删除，加入选择列表
        sumNow = sumNow - cur.val;
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(8);
        TreeNode root = new TreeNode(5, l1, r1);
        TreeNode l2 = new TreeNode(11);
        l1.left = l2;
        l2.left = new TreeNode(7);
        l2.right = new TreeNode(2);
        r1.left = new TreeNode(13);
        r1.right = new TreeNode(4);
        r1.right.right = new TreeNode(1);


        System.out.println(hasPathSum(root, 23));

    }
}
