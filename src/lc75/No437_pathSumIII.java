package lc75;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75">路径总和III</a>
 */
public class No437_pathSumIII {

    int count;

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        dfs(root, targetSum, true);
        return count;
    }

    public void dfs(TreeNode root, long sumNow, boolean canStart) {
        if (root == null) {
            return;
        }
        // 开启新的path，当前值不在链路中
        if (canStart) {
            dfs(root.left, sumNow, canStart);
            dfs(root.right, sumNow, canStart);
        }
        // 在链路中，当前值计算在路径中
        dfs(root.left, sumNow - Long.valueOf(root.val), false);
        dfs(root.right, sumNow - Long.valueOf(root.val), false);
        if (Long.valueOf(root.val).longValue() == sumNow) {
            count++;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root3 = createTree("1000000000,1000000000,null,294967296,null,null,null,1000000000,null,null,null,null,null,null,null,1000000000,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,1000000000");
        System.out.println(pathSum(root3, 0));
//        TreeNode root = createTree("1,null,2,null,null,null,3,null,null,null,null,null,null,null,4,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,5");
//        System.out.println(pathSum(root, 3));
//        TreeNode root2 = createTree("10,5,-3,3,2,null,11,3,-2,null,1");
//        System.out.println(pathSum(root2, 8));
    }


}
