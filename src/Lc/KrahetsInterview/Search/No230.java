package Lc.KrahetsInterview.Search;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">二叉搜索熟中找到第k大的元素</a>
 **/
public class No230 {
    ArrayList<Integer> res = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        backtrack(root, k);
        return res.get(k - 1);
    }

    public void backtrack(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            backtrack(node.left, k);
        }
        res.add(node.val);
        if (res.size() == k) {
            return;
        }
        if (node.right != null) {
            backtrack(node.right, k);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode head = createTree("1,null,2");
        int res = kthSmallest(head, 2);
        System.out.println(res);

    }

}

