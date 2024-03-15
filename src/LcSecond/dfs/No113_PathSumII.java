package LcSecond.dfs;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/path-sum-ii/description/">路径之和2</a>
 **/
public class No113_PathSumII {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        ps(root, targetSum, new ArrayList<>());
        return result;
    }

    public void ps(TreeNode root, int targetSum, ArrayList<Integer> path) {
        if (root != null && root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ArrayList<Integer> item = new ArrayList<>(path);
                item.add(root.val);
                result.add(item);
            }
            return;
        }
        if (root == null) {
            return;
        }
        path.add(root.val);
        ps(root.left, targetSum - root.val, path);
        ps(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
    }

}
