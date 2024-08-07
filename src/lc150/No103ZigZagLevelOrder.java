package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No103ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        boolean left2Right = true;
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
                if (left2Right) {
                    layer.add(item.val);
                } else {
                    layer.add(0, item.val);
                }
            }
            left2Right = !left2Right;
            res.add(layer);
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("3,9,20,null,null,15,7");
        List<List<Integer>> x = zigzagLevelOrder(root);
        for (List<Integer> item : x) {
            System.out.println(item);
        }

    }
}
