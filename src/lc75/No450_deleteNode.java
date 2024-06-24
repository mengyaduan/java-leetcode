package lc75;

import DataStruct.TreeNode;

/**
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/?envType=study-plan-v2&envId=leetcode-75">删除BST节点</a>
 */
public class No450_deleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode[] toDelete = findNode(null, root, key);
        if (toDelete[1] == null) {
            // 没找到要删除的节点
            return root;
        }
        if (toDelete[0] == null) {
            return removeTargetNode(root);
        } else {
            if (toDelete[0].left == toDelete[1]) {
                toDelete[0].left = removeTargetNode(toDelete[1]);
            } else {
                toDelete[0].right = removeTargetNode(toDelete[1]);
            }
            return root;
        }
    }

    public TreeNode removeTargetNode(TreeNode target) {
        if (target == null) {
            return null;
        }
        if (target.left == null && target.right == null) {
            return null;
        } else if (target.left == null && target.right != null) {
            // 左空右非空
            return target.right;
        } else if (target.left != null && target.right == null) {
            // 左非空右空
            return target.left;
        } else {
            // 左右均不为空，那么找到左边最大的就行了
            TreeNode item = target.left;
            TreeNode itemFather = null;
            while (item.right != null) {
                itemFather = item;
                item = item.right;
            }
            if (itemFather == null) {
                // target.left没有右子树
                target.left.right = target.right;
                return target.left;
            }
            target.val = item.val;
            itemFather.right = item.left;
            return target;
        }
    }

    public TreeNode[] findNode(TreeNode pre, TreeNode root, int val) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (root.val == val) {
            return new TreeNode[]{pre, root};
        } else if (root.val < val) {
            return findNode(root, root.right, val);
        } else {
            return findNode(root, root.left, val);
        }
    }

}
