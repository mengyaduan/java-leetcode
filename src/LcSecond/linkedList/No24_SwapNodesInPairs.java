package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/">成对交换节点</a>
 **/
public class No24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while (prev.next != null && cur.next != null) {
            ListNode left = prev.next;
            ListNode right = cur.next;
            left.next = right.next;
            prev.next = right;
            right.next = left;
            prev = left;
            cur = left.next;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(swapPairs(head));
    }

    @Test(description = "")
    public void test2() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4);
        System.out.println(swapPairs(head));
    }
}
