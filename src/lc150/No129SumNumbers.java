package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No129SumNumbers {

    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }


    public void dfs(TreeNode root, int path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 抵达叶子
            res += path * 10 + root.val;
        }
        dfs(root.left, path * 10 + root.val);
        dfs(root.right, path * 10 + root.val);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("4,9,0,5,1");
        System.out.println(sumNumbers(root));
    }

}
