package LcSecond.dfs;


import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/">二叉树最小深度</a>
 **/
public class No111_MinDepthOfBT {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        int result = 0;
        helper.addLast(root);
        while (!helper.isEmpty()) {
            result++;
            int sizeNow = helper.size();
            while (sizeNow != 0) {
                TreeNode item = helper.pollFirst();
                sizeNow--;
                if (item.left == null && item.right == null) {
                    // 抵达叶子节点，直接退出
                    return result;
                } else {
                    if (item.left != null) {
                        helper.add(item.left);
                    }
                    if (item.right != null) {
                        helper.add(item.right);
                    }
                }
            }
        }
        return result;
    }

    public int minDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepthRec(root.right);
        }
        if (root.right == null) {
            return 1 + minDepthRec(root.left);
        }
        return Math.min(minDepthRec(root.left), minDepthRec(root.right)) + 1;
    }

    public int minDepthRecursion(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            // 到达叶子节点了才返回1
            return 1;
        }
        if (root == null) {
            return 0;
        }
        int x = minDepthRecursion(root.left);
        int y = minDepthRecursion(root.right);
        x = x == 0 ? Integer.MAX_VALUE : x;
        y = y == 0 ? Integer.MAX_VALUE : y;
        return 1 + Math.min(x, y);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,null,2,null, null,null,3");
        System.out.println(minDepthRecursion(root));

    }

}
