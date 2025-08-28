package LC100Again;


import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

import static DataStruct.tools.createTree;

public class Lc048 {

    HashMap<Long, Long> preSum;

    int result;

    public int pathSum(TreeNode root, int targetSum) {
        result = 0;
        preSum = new HashMap<>();
        preSum.put(0L, 1L);
        traversal(root, targetSum, 0, preSum);
        return result;
    }

    private void traversal(TreeNode root, int targetSum, long pre, HashMap<Long, Long> preSum) {
        if (root == null) {
            return;
        }
        // 检查前缀和中，有没有需要的值，如果有，则++
        long now = pre + root.val;
        if (preSum.containsKey(now - targetSum)) {
            result += preSum.get(now - targetSum);
        }
        preSum.put(now, preSum.getOrDefault(now, 0L) + 1);
        // 继续遍历左右
        traversal(root.left, targetSum, now, preSum);
        traversal(root.right, targetSum, now, preSum);
        // 遍历完以后，需要将本层的值从前缀和中删除
        preSum.put(now, preSum.get(now) - 1);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("10,5,-3,3,2,null,11,3,-2,null,1");
        System.out.println(pathSum(root, 8));

    }


}
