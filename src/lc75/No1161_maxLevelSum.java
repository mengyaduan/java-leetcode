package lc75;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75">最大层内元素和</a>
 */
public class No1161_maxLevelSum {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        int count = 1;
        while (!helper.isEmpty()) {
            int layerSum = 0;
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.poll();
                layerSum += item.val;
                if (item.left != null) {
                    helper.add(item.left);
                }
                if (item.right != null) {
                    helper.add(item.right);
                }
            }
            if (layerSum > maxSum) {
                maxSum = layerSum;
                res = count;
            }
            count++;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,7,0,7,-8");
        System.out.println(maxLevelSum(root));
    }
}
