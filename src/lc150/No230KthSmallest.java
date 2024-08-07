package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No230KthSmallest {

    int ans;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        count = 0;
        inorderTr(root, k);
        return ans;
    }

    public void inorderTr(TreeNode root, int k) {
        if (ans!=-1 || root == null) {
            return;
        }
        inorderTr(root.left, k);
        count += 1;
        if (count == k) {
            ans = root.val;
        }
        inorderTr(root.right, k);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("3,1,4,null,2");
        System.out.println(kthSmallest(root, 1));


    }
}
