package Lc119;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static DataStruct.tools.createTree;

public class LCR044 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.addLast(root);
        while (!helper.isEmpty()) {
            int layerMax = Integer.MIN_VALUE;
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                layerMax = Math.max(layerMax, item.val);
                if (item.left != null) {
                    helper.addLast(item.left);
                }
                if (item.right != null) {
                    helper.addLast(item.right);
                }
            }
            result.add(layerMax);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,5,32,1,123,213,123,456,6");
        System.out.println(largestValues(root));

    }

}
