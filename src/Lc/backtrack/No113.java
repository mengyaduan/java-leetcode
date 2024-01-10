package Lc.backtrack;

import DataStruct.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/path-sum-ii/?show=1">no113 计算路径总和 2</a>
 */
public class No113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        backtrack(path, root, 0, targetSum);
        return res;
    }


    public void backtrack(List<Integer> singlePath, TreeNode cur, int sumNow, int targetSum) {
        // 结束条件及操作
        if (cur.left == null && cur.right == null) {
            sumNow += cur.val;
            if (sumNow == targetSum) {
                ArrayList<Integer> thisTurn = new ArrayList<>(singlePath);
                thisTurn.add(cur.val);
                res.add(thisTurn);
            }
            return;
        }
        // 加入路径，从选择列表中删除
        sumNow = sumNow + cur.val;
        singlePath.add(cur.val);
        // nextLevel
        if (cur.left != null) {
            backtrack(singlePath, cur.left, sumNow, targetSum);
        }
        if (cur.right != null) {
            backtrack(singlePath, cur.right, sumNow, targetSum);
        }
        // 从路径中删除，加入选择列表
        sumNow = sumNow - cur.val;
        int size = singlePath.size();
        singlePath.remove(size - 1);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(8);
        TreeNode root = new TreeNode(5, l1, r1);
        TreeNode l2 = new TreeNode(11);
        l1.left = l2;
        l2.left = new TreeNode(7);
        l2.right = new TreeNode(2);
        r1.left = new TreeNode(13);
        r1.right = new TreeNode(4);
        r1.right.left = new TreeNode(5);
        r1.right.right = new TreeNode(1);

        List<List<Integer>> x = pathSum(root, 22);
        for (List<Integer> item : x) {
            System.out.println(StringUtils.join(item, ","));
        }


    }
}
