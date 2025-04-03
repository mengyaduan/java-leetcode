package Lc119;

import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LCR046 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.addLast(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                if (i == size - 1) {
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

}
