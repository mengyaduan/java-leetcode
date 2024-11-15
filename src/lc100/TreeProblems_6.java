package lc100;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

public class TreeProblems_6 {

    /**
     * 226
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    @Test(description = "")
    public void testInvertTree() throws Exception {
        TreeNode root = createTree("1,2,3,4,5,6,7,8");
        printTree(invertTree(root));
    }

    /**
     * 101
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTwo(root.left, root.right);
    }

    public boolean isSymmetricTwo(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 != null && r2 != null) {
            return r1.val == r2.val && isSymmetricTwo(r1.left, r2.right) && isSymmetricTwo(r1.right, r2.left);
        } else {
            return false;
        }
    }

    int diameter = 0;

    /**
     * 543
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        maxDepth(root);
        return diameter - 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        diameter = Math.max(diameter, leftLen + rightLen + 1);
        return Math.max(leftLen, rightLen) + 1;
    }

    @Test(description = "")
    public void testDiameter() throws Exception {
        TreeNode root = createTree("1,2,3,4,5");
        System.out.println(diameterOfBinaryTree(root));
        root = createTree("1,2");
        System.out.println(diameterOfBinaryTree(root));

    }

    /**
     * 102
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.addLast(root);
        while (!helper.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = helper.pollFirst();
                layer.add(head.val);
                if (head.left != null) {
                    helper.addLast(head.left);
                }
                if (head.right != null) {
                    helper.addLast(head.right);
                }
            }
            result.add(layer);
        }
        return result;
    }

    /**
     * 108
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted2Bst(nums, 0, nums.length - 1);
    }

    public TreeNode sorted2Bst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sorted2Bst(nums, left, mid - 1);
        root.right = sorted2Bst(nums, mid + 1, right);
        return root;
    }

    @Test(description = "")
    public void testSorted2Bst() throws Exception {
        printTree(sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6}));
    }

    /**
     * 98
     * 方法1：中序遍历，然后要单调递增才对
     * 方法2：dfs，每次更新当前节点的一个区间值
     */
    public boolean isValidBST_1(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int cur = inorder.get(0);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= cur) {
                return false;
            }
            cur = inorder.get(i);
        }
        return true;
    }

    public void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    public boolean isValidBST_2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBst(root.left, Long.MIN_VALUE, (long) root.val) && isValidBst(root.right, (long) root.val, Long.MAX_VALUE);
    }

    public boolean isValidBst(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
        return isValidBst(root.left, low, root.val) && isValidBst(root.right, root.val, high);
    }

}
