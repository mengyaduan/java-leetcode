package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LCR025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> n1 = new ArrayDeque<>();
        Deque<ListNode> n2 = new ArrayDeque<>();
        while (l1 != null) {
            n1.addLast(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            n2.addLast(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        while (!n1.isEmpty() || !n2.isEmpty() || carry != 0) {
            int a = n1.isEmpty() ? 0 : n1.pollLast().val;
            int b = n2.isEmpty() ? 0 : n2.pollLast().val;
            int item = a + b + carry;
            ListNode cur = new ListNode(item % 10);
            carry = item / 10;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode x = ListNode.createListNode(7, 2, 4, 3);
        ListNode y = ListNode.createListNode(5, 6, 4);
        System.out.println(addTwoNumbers(x, y));

    }

}
