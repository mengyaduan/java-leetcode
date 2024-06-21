package lc75;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75">二叉树中的最长交错路径</a>
 */
public class No1372_longestZigZag {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        dfs(root.right, 1, 0);
        dfs(root.left, -1, 0);
        return res;
    }

    /**
     * @param nextDirection 接下来要走的方向, 1是向左，-1是向右
     * @param path          走到当前节点的路径和
     */
    public void dfs(TreeNode root, int nextDirection, int path) {
        if (root == null) {
            return;
        }
        path++;
        res = Math.max(res, path);
        if (nextDirection == 1) {
            dfs(root.left, -nextDirection, path);
            dfs(root.right, nextDirection, 0);
        } else {
            dfs(root.right, -nextDirection, path);
            dfs(root.left, nextDirection, 0);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root2 = createTree("1,1,1,1,null,null,1");
        System.out.println(longestZigZag(root2));
        TreeNode root = createTree("1,1,1,null,1,null,null,null,null,1,1,null,null,null,null,null,null,null,null,null,1");
        System.out.println(longestZigZag(root));

    }
}
