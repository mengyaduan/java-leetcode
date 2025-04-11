package Lc119;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static DataStruct.tools.createTree;

public class LCR050 {

    int result;

    public int pathSum(TreeNode root, int targetSum) {
        result = 0;
        dfs(root, targetSum, new ArrayList<>());
        return result;

    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Long> path) {
        if (root == null) {
            return;
        }
        // 将path的值与当前值相加，并更新
        ArrayList<Long> newPath = new ArrayList<>();
        for (Long item : path) {
            newPath.add(item + root.val);
            if (item + root.val == targetSum) {
                result++;
            }
        }
        newPath.add((long) root.val);
        if (root.val == targetSum) {
            result++;
        }
        dfs(root.left, targetSum, newPath);
        dfs(root.right, targetSum, newPath);
    }


    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("10,5,-3,3,2,null,11,3,-2,null,1");
        System.out.println(pathSum(root, 8));
        TreeNode root2 = createTree("5,4,8,11,null,13,4,7,2,null,null,5,1");
        System.out.println(pathSum(root2, 22));

    }
}
