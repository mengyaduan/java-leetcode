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
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/"></a>
 **/
public class No102 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> helper = new ArrayDeque<>();
        Deque<TreeNode> subHelper = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        helper.add(root);
        while (!helper.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();
            // 遍历一层
            while (!helper.isEmpty()) {
                TreeNode item = helper.pollFirst();
                layer.add(item.val);
                if (item.left != null) {
                    subHelper.add(item.left);
                }
                if (item.right != null) {
                    subHelper.add(item.right);
                }
            }
            result.add(layer);
            helper = subHelper;
            subHelper = new ArrayDeque<>();
        }
        return result;
    }

    @Test(description = "")
    public void testo() throws Exception {
        TreeNode head = createTree("3,9,20,null,2,15,7,4,5,6,7,3,2,4,1,2,2");

        List<List<Integer>> mm = levelOrder(head);
        for (List<Integer> m : mm) {
            System.out.println(StringUtils.join(m, ","));
        }


    }

}

