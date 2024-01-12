package Lc.KrahetsInterview.Search;

import DataStruct.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/">锯齿形遍历二叉树</a>
 **/
public class No103 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> helper = new ArrayDeque<>();
        Deque<TreeNode> subHelper = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        boolean left2right = true;
        helper.add(root);
        while (!helper.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();
            while (!helper.isEmpty()) {
                TreeNode item = helper.pollLast();
                layer.add(item.val);
                if (left2right) {
                    if (item.left != null) {
                        subHelper.add(item.left);
                    }
                    if (item.right != null) {
                        subHelper.add(item.right);
                    }
                } else {
                    if (item.right != null) {
                        subHelper.add(item.right);
                    }
                    if (item.left != null) {
                        subHelper.add(item.left);
                    }
                }
            }
            result.add(layer);
            // 翻转
            left2right = !left2right;
            helper = subHelper;
            subHelper = new ArrayDeque<>();
        }
        return result;
    }

    @Test(description = "")
    public void testo() throws Exception {
        TreeNode head = createTree("1,2,3,4,5,6,7,8,9,10");

        List<List<Integer>> mm = zigzagLevelOrder(head);
        for (List<Integer> m : mm) {
            System.out.println(StringUtils.join(m, ","));
        }


    }

}

