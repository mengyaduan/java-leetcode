package lc75;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=leetcode-75">二叉树的右视图</a>
 */
public class No199_rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        int size = 1;
        while (!helper.isEmpty()) {
            TreeNode item = null;
            size = helper.size();
            for (int i = 0; i < size; i++) {
                item = helper.poll();
                if (item.left != null) {
                    helper.add(item.left);
                }
                if (item.right != null) {
                    helper.add(item.right);
                }
            }
            res.add(item.val);
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,2,3,null,5,null,4");
        System.out.println(rightSideView(root));
    }


}
