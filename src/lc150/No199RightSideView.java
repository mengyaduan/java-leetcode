package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No199RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            TreeNode item = null;
            for (int i = 0; i < size; i++) {
                item = helper.pollFirst();
                if (item.left != null) {
                    helper.addLast(item.left);
                }
                if (item.right != null) {
                    helper.addLast(item.right);
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
