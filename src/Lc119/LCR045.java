package Lc119;

import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCR045 {

    public int findBottomLeftValue(TreeNode root) {
        int result = root.val;
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.addLast(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                if (i == 0) {
                    result = item.val;
                }
                if (item.left != null) {
                    helper.addLast(item.left);
                }
                if (item.right != null) {
                    helper.addLast(item.right);
                }
            }
        }
        return result;
    }

}
