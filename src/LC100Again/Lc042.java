package LC100Again;


import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;

public class Lc042 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums, 0, nums.length - 1);
    }

    public TreeNode sorted(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = i + (j - i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sorted(nums, i, mid - 1);
        root.right = sorted(nums, mid + 1, j);
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode x = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        printTree(x);
        x = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9, 10});
        printTree(x);
        x = sortedArrayToBST(new int[]{-10});
        printTree(x);

    }


}
