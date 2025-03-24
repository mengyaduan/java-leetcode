package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class LCR021 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, pre = dummy;
        int count = 0;
        while (fast != null) {
            fast = fast.next;
            if (count >= n + 1) {
                pre = pre.next;
            }
            count++;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(removeNthFromEnd(head, 5));

    }
}
