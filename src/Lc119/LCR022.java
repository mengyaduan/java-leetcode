package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class LCR022 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 找到相遇点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // 没有交叉点，无环
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(3, 2, 0, 4);
        head.next.next.next.next = head.next;
        ListNode res = detectCycle(head);
        System.out.println(res);


    }
}
