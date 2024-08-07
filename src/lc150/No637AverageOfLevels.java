package lc150;

import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No637AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            double layerSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                if (item.left != null) {
                    helper.addLast(item.left);
                }
                if (item.right != null) {
                    helper.addLast(item.right);
                }
                layerSum += item.val;
            }
            res.add(layerSum / size);
        }
        return res;
    }
}
