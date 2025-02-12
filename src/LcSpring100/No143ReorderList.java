package LcSpring100;

import DataStruct.ListNode;

public class No143ReorderList {

    public void reorderList(ListNode head) {
        // 拆成两个链表
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        // 翻转后半段
        ListNode r = reverse(right);
        // 合并
        merge(head, r);
    }

    private void merge(ListNode head, ListNode r) {
        ListNode cur = head;
        while (r != null) {
            ListNode insertion = r;
            r = r.next;
            insertion.next = cur.next;
            cur.next = insertion;
            cur = cur.next.next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head;
        while (cur.next != null) {
            ListNode item = cur.next;
            cur.next = item.next;
            item.next = dummy.next;
            dummy.next = item;
        }
        return dummy.next;
    }


}
