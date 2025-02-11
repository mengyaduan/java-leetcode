package LcSpring100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(1, head);
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            // 只有满足条件才需要交换
            ListNode left = pre.next;
            ListNode right = left.next;
            left.next = right.next;
            pre.next = right;
            right.next = left;
            pre = left;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6, 7);
        System.out.println(swapPairs(head));
        head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(swapPairs(head));
        head = ListNode.createListNode(1);
        System.out.println(swapPairs(head));
        head = ListNode.createListNode();
        System.out.println(swapPairs(head));

    }
}
