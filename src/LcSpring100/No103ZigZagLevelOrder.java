package LcSpring100;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static DataStruct.tools.createTree;

public class No103ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.addLast(root);
        boolean l2R = true;
        while (!helper.isEmpty()) {
            int size = helper.size();
            ArrayList<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (l2R) {
                    TreeNode item = helper.pollFirst();
                    layer.add(item.val);
                    if (item.left != null) {
                        helper.addLast(item.left);
                    }
                    if (item.right != null) {
                        helper.addLast(item.right);
                    }
                } else {
                    TreeNode item = helper.pollLast();
                    layer.add(item.val);
                    if (item.right != null) {
                        helper.addFirst(item.right);
                    }
                    if (item.left != null) {
                        helper.addFirst(item.left);
                    }
                }
            }
            result.add(layer);
            l2R = !l2R;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,2,3,4,5,6,7");
        zigzagLevelOrder(root);

    }

}
