package LC100Again;


import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc045 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.offerLast(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                if (item.left != null) {
                    helper.offerLast(item.left);
                }
                if (item.right != null) {
                    helper.offerLast(item.right);
                }
                if (i == size - 1) {
                    result.add(item.val);
                }
            }
        }
        return result;
    }


}
