package lc150;

import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No102LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        while (!helper.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                if (item.left != null) {
                    helper.addLast(item.left);
                }
                if (item.right != null) {
                    helper.addLast(item.right);
                }
                layer.add(item.val);
            }
            res.add(layer);
        }
        return res;
    }
}
