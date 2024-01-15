package Lc.KrahetsInterview.BackTrack;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/path-sum-ii/description/">路径之和 II</a>
 **/
public class No113 {

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(root, targetSum, path);
        return res;
    }

    private void backtrack(TreeNode node, int targetSum, ArrayList<Integer> path) {
        // 终止条件
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (path.stream().mapToInt(Integer::valueOf).sum() + node.val == targetSum) {
                ArrayList<Integer> tmp = new ArrayList<>(path);
                tmp.add(node.val);
                res.add(tmp);
            }
            return;
        }
        // 备选路径
        path.add(node.val);
        // 回溯
        if (node.left != null) {
            backtrack(node.left, targetSum, path);
        }
        if (node.right != null) {
            backtrack(node.right, targetSum, path);
        }
        // 删除
        path.remove(path.size() - 1);
    }

}

