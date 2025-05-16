package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class LCR077 {
    public ListNode sortList(ListNode head) {
        // 如果只有一个节点或null，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 一分为二
        ListNode[] heads = splitHalf(head);
        // 得到两个有序节点
        ListNode h0 = sortList(heads[0]);
        ListNode h1 = sortList(heads[1]);
        // 合并两个有序节点
        return merge(h0, h1);

    }

    private ListNode[] splitHalf(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode[] result = new ListNode[]{head, slow.next};
        slow.next = null;
        return result;
    }

    private ListNode merge(ListNode head, ListNode head1) {
        ListNode result = new ListNode();
        ListNode cur = result;
        while (head != null && head1 != null) {
            if (head.val <= head1.val) {
                cur.next = head;
                head = head.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head == null ? head1 : head;
        return result.next;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(4, 5, 32, 431, 2, 3);
        System.out.println(sortList(head));

    }

}
