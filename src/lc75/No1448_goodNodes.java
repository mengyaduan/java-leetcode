package lc75;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75">二叉树中的好节点</a>
 */
public class No1448_goodNodes {


    int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    public void dfs(TreeNode root, int maxBefore) {
        if (root == null) {
            return;
        }
        if (root.val >= maxBefore) {
            count++;
            maxBefore = root.val;
        }
        dfs(root.left, maxBefore);
        dfs(root.right, maxBefore);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("3,1,4,3,null,1,5");
        System.out.println(goodNodes(root));


    }
}

