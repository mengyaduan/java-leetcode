package LcSecond.linkedList;

import DataStruct.ListNode;
import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;

/**
 * @see <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/">将有序的链表转成平衡二叉搜索树</a>
 **/
public class No109_SortedListToBST {


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        // 找到中点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(-10);
        TreeNode root = sortedListToBST(head);
        printTree(root);
    }

}

