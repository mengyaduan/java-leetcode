package LcSpring100;

import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No107LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            ArrayList<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                layer.add(item.val);
                if (item.left != null) {
                    helper.offerLast(item.left);
                }
                if (item.right != null) {
                    helper.offerLast(item.right);
                }
            }
            result.add(0, layer);
        }
        return result;
    }


}
