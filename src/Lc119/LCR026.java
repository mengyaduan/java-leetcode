package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class LCR026 {

    public void reorderList(ListNode head) {
        // 先找到中点，拆成两个链表
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        // 倒序后半段
        head2 = reverseList(head2);
        // 拼接成新的
        ListNode cur = head2;
        ListNode pivot = dummy.next;
        while (cur != null) {
            ListNode insertion = pivot;
            pivot = pivot.next;
            insertion.next = cur;
            cur = cur.next;
            insertion.next.next = pivot;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            // 单个节点直接返回
            return head;
        }
        ListNode tmp = head.next;
        ListNode reversed = reverseList(head.next);
        tmp.next = head;
        head.next = null;
        return reversed;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1);
        reorderList(head);
        System.out.println(head);

        ListNode head2 = ListNode.createListNode(1, 2);
        reorderList(head2);
        System.out.println(head2);
    }

}
