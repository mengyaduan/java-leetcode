package lc100;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.*;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

public class TreeProblems_12 {

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


    int kthSmall = 0;
    int count;

    /**
     * 230
     */
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTraversal(root);
        return kthSmall;
    }

    public int inorderTraversal(TreeNode root) {
        if (root == null || count < 0) {
            return -1;
        }
        inorderTraversal(root.left);
        count--;
        if (count == 0) {
            kthSmall = root.val;
            return 1;
        }
        inorderTraversal(root.right);
        return -1;
    }

    @Test(description = "")
    public void testKthSmallest() throws Exception {
        PriorityQueue<Integer> helper = new PriorityQueue<>((a, b) -> b - a);
        helper.add(1);
        helper.add(2);
        helper.add(3);
        System.out.println(helper.poll());


    }


    /**
     * 199
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        while (helper.size() > 0) {
            int layerSize = helper.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode item = helper.pollFirst();
                if (i == layerSize - 1) {
                    result.add(item.val);
                }
                if (item.left != null) {
                    helper.add(item.left);
                }
                if (item.right != null) {
                    helper.add(item.right);
                }
            }
        }
        return result;
    }

    /**
     * 114
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode right = root.right;
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            TreeNode cur = root.right;
            while (cur != null && cur.right != null) {
                cur = cur.right;
            }
            flatten(right);
            cur.right = right;
        } else {
            flatten(root.right);
        }
    }

    @Test(description = "")
    public void testFlatten() throws Exception {
        TreeNode root = createTree("1,2,5,3,4,null,6");
        flatten(root);
        printTree(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int[] preorder, int rootNumIdx, int[] inorder, int start, int end) {
        if (end < start) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootNumIdx]);
        int idxInInorder = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                idxInInorder = i;
                break;
            }
        }
        int leftNodes = idxInInorder - start;
        root.left = buildSubTree(preorder, rootNumIdx + 1, inorder, start, idxInInorder - 1);
        root.right = buildSubTree(preorder, rootNumIdx + leftNodes + 1, inorder, idxInInorder + 1, end);
        return root;
    }

    @Test(description = "")
    public void testBuildTree() throws Exception {
        printTree(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));

        printTree(buildTree(new int[]{1}, new int[]{1}));
    }

    /**
     * 437
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        HashMap<Long, Integer> preSum = new HashMap<>();
        preSum.put(0L, 1);
        return dfs(root, preSum, 0, targetSum);
    }

    public int dfs(TreeNode root, HashMap<Long, Integer> preSum, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        curr += root.val;
        ret = preSum.getOrDefault(curr - targetSum, 0);
        preSum.put(curr, preSum.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, preSum, curr, targetSum);
        ret += dfs(root.right, preSum, curr, targetSum);
        preSum.put(curr, preSum.getOrDefault(curr, 0) - 1);
        return ret;
    }

    @Test(description = "")
    public void testPathSum() throws Exception {
        TreeNode root = createTree("10,5,-3,3,2,null,11,3,-2,null,1");
        System.out.println(pathSum(root, 8));

        root = createTree("0,1,1");
        System.out.println(pathSum(root, 0));


    }


    /**
     * 236
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }


    int maxPathSum = 0;

    /**
     * 124
     */
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        dfs(root);
        return maxPathSum;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            // 分别代表root+left，root+right，root+left+right
            return new int[3];
        }
        int[] res = new int[3];
        int[] left = dfs(root.left);
        res[0] = Math.max(root.val + Math.max(left[0], left[1]), root.val);
        int[] right = dfs(root.right);
        res[1] = Math.max(root.val + Math.max(right[0], right[1]), root.val);
        res[2] = Math.max(res[0] + res[1] - root.val, root.val);
        maxPathSum = Math.max(maxPathSum, res[0]);
        maxPathSum = Math.max(maxPathSum, res[1]);
        maxPathSum = Math.max(maxPathSum, res[2]);
        return res;
    }

    @Test(description = "")
    public void testMaxPathSum() throws Exception {
        TreeNode root = createTree("-10,9,20,null,null,15,7");
        System.out.println(maxPathSum(root));
        root = createTree("-10,9,20");
        System.out.println(maxPathSum(root));
        root = createTree("10,-9,-20");
        System.out.println(maxPathSum(root));

    }


}
