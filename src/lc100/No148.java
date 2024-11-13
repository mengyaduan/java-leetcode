package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中点，切成两个list
        ListNode fast = head, slow = head;
        ListNode pre = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        // head和slow就是两个链表，继续调用sortList，使其有序
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(slow);
        // 合并两个链表
        if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        } else {
            return mergeTwoSortedList(h1, h2);
        }
    }

    private ListNode mergeTwoSortedList(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                pre.next = h2;
                break;
            } else if (h2 == null) {
                pre.next = h1;
                break;
            } else {
                if (h1.val <= h2.val) {
                    pre.next = h1;
                    h1 = h1.next;
                } else {
                    pre.next = h2;
                    h2 = h2.next;
                }
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(-1, 5, 0, 3, 4);
        System.out.println(sortList(head));

    }

}
