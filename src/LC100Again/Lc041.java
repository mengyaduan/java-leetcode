package LC100Again;


import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc041 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.offerLast(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            List<Integer> cache = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                cache.add(item.val);
                if (item.left != null) {
                    helper.offerLast(item.left);
                }
                if (item.right != null) {
                    helper.offerLast(item.right);
                }
            }
            result.add(cache);
        }
        return result;
    }

}
