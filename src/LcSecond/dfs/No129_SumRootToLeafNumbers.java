package LcSecond.dfs;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/description/">根节点到叶节点之和</a>
 **/
public class No129_SumRootToLeafNumbers {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
//        backtrack(root, new ArrayList<>());
        dfs(root, 0);
        return res;
    }

    public void backtrack(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ArrayList<Integer> tmp = new ArrayList<>(path);
            tmp.add(root.val);
            int bit = 1;
            for (int i = tmp.size() - 1; i >= 0; i--) {
                res += tmp.get(i) * bit;
                bit *= 10;
            }
            return;
        }
        path.add(root.val);
        backtrack(root.left, path);
        backtrack(root.right, path);
        path.remove(path.size() - 1);
    }

    public void dfs(TreeNode root, int curNum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res += curNum * 10 + root.val;
            return;
        }
        int newCur = curNum * 10 + root.val;
        dfs(root.left, newCur);
        dfs(root.right, newCur);
    }

    @Test(description = "")
    public void testo() throws Exception {
        TreeNode root = createTree("4,9,0,5,1");
        System.out.println(sumNumbers(root));

    }

}

