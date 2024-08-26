package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;

/**
 * @see <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No108SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBst(nums, 0, nums.length - 1);
    }

    private TreeNode toBst(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBst(nums, l, mid - 1);
        root.right = toBst(nums, mid + 1, r);
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = sortedArrayToBST(new int[]{
                -10, -3, 0, 5, 9
        });
        printTree(root);
    }

}
