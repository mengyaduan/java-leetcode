package Lc.doublepointers;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/">两两交换链表中的节点</a>
 **/
public class No24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode curPre = pre;
        while (head != null && head.next != null) {
            ListNode q = head.next;
            head.next = head.next.next;
            q.next = head;
            curPre.next = q;

            curPre = head;
            head = head.next;
        }
        return pre.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4);
        System.out.println(swapPairs(head));
        ListNode head1 = ListNode.createListNode(1);
        System.out.println(swapPairs(head1));
        ListNode head2 = ListNode.createListNode();
        System.out.println(swapPairs(head2));
        ListNode head3 = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(swapPairs(head3));

    }


}

