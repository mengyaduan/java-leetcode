package LcSecond.linkedList;

import DataStruct.ListNode;
import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.HashMap;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-in-binary-tree/">在二叉树中找链表</a>
 **/
public class No1367_LinkedListInBT {
    HashMap<TreeNode, HashMap<ListNode, Boolean>> memo;

    public boolean isSubPath(ListNode head, TreeNode root) {
        memo = new HashMap<>();
        return dfs(head, head, root);
    }

    /**
     * @param headOri 原始头
     * @param head    如果inSeq，则是新的头
     * @param root
     * @return
     */
    public boolean dfs(ListNode headOri, ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (memo.containsKey(root) && memo.get(root).containsKey(head)) {
            return memo.get(root).get(head);
        }

        boolean eq = false;
        if (head.val == root.val) {
            eq = dfs(headOri, head.next, root.left) || dfs(headOri, head.next, root.right);
        }
        boolean result = eq || dfs(headOri, headOri, root.left) || dfs(headOri, headOri, root.right);
        memo.putIfAbsent(root, new HashMap<>());
        memo.get(root).put(head, result);
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(2, 4, 8);
        TreeNode root = createTree("1,4,4,null,2,2,null,null,null,1,null,6,8,null,null,null,null,1,3");
        System.out.println(isSubPath(head, root));

    }
}
