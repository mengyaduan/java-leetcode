package Lc.search;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.cn/problems/sum-of-nodes-with-even-valued-grandparent/">祖父节点值为偶数的节点和</a>
 **/
public class No1315 {
    int sum = 0;
    ArrayList<TreeNode> toSum = new ArrayList<>();

    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        for (TreeNode node : toSum) {
            if (node.left != null) {
                sum += node.left.val;
            }
            if (node.right != null) {
                sum += node.right.val;
            }
        }
        return sum;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0) {
            if (root.left != null) {
                toSum.add(root.left);
            }
            if (root.right != null) {
                toSum.add(root.right);
            }
        }
        traverse(root.left);
        traverse(root.right);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        System.out.println(sumEvenGrandparent(root));

    }

}