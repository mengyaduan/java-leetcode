package Lc.linkedlist;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">删除链表中的重复元素</a>
 **/
public class No83_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur;
        while (pre != null) {
            cur = pre.next;
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
                pre.next = cur;
            }
            pre = pre.next;
        }
        return head;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 1, 1, 2, 3, 4, 5, 5, 5, 5, 6);
        System.out.println(deleteDuplicates(head));
        head = ListNode.createListNode(1, 2, 3, 4);
        System.out.println(deleteDuplicates(head));
        head = ListNode.createListNode(4);
        System.out.println(deleteDuplicates(head));

    }
}

