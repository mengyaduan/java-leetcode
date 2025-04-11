package Lc119;

import DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCR053 {

    TreeNode result;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        findP(root, p, new ArrayDeque<>());
        return result;
    }

    private void findP(TreeNode root, TreeNode p, Deque<TreeNode> helper) {
        if (root == p) {
            // 优先找p的右子树中，最左侧的值
            if (p.right != null) {
                TreeNode pre = p.right;
                TreeNode cur = pre.left;
                while (cur != null) {
                    pre = cur;
                    cur = cur.left;
                }
                result = pre;
                return;
            }
            // 然后一路往父节点上找
            while (!helper.isEmpty()){
                TreeNode item = helper.pollLast();
                if (item.val > p.val){
                    result = item;
                    break;
                }
            }
            return;
        }
        helper.addLast(root);
        if (root.val > p.val) {
            findP(root.left, p, helper);
        } else {
            findP(root.right, p, helper);
        }
        helper.pollLast();
    }


}
