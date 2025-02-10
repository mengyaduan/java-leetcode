package LcSpring100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.List;

public class No61RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while (fast != null && fast.next != null) {
            if (k > 0) {
                k--;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        // fast指向head，slow指向null
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(0 % 12);

    }

}
