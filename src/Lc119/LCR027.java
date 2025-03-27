package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class LCR027 {

    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 从mid往后开始，操作倒序，mid不要动
        ListNode mid = slow;
        ListNode cur = slow.next;
        while (cur != null && cur.next != null) {
            ListNode item = cur.next;
            cur.next = item.next;
            item.next = mid.next;
            mid.next = item;
        }
        // 从头开始和mid比较
        ListNode left = dummy.next;
        ListNode right = mid.next;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1);
        System.out.println(isPalindrome(head));

        ListNode head2 = ListNode.createListNode(1, 2, 3, 3, 2, 1);
        System.out.println(isPalindrome(head2));
        ListNode head3 = ListNode.createListNode(1, 2, 3, 2, 1);
        System.out.println(isPalindrome(head3));
    }
}
