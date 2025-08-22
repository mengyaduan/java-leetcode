package LC100Again;


import DataStruct.ListNode;
import org.testng.annotations.Test;

public class Lc024 {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        // 翻转从mid以后的所有节点
        ListNode cur = mid.next;
        while (cur != null && cur.next != null) {
            ListNode insertion = cur.next;
            ListNode tail = insertion.next;
            cur.next = tail;
            insertion.next = mid.next;
            mid.next = insertion;
        }
        System.out.println(head);
        // 从头开始比较
        ListNode cur1 = head, cur2 = mid.next;
        while (cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 3, 2, 1);
        System.out.println(isPalindrome(head));
        ListNode head2 = ListNode.createListNode(1, 2, 3, 4, 4, 3, 2, 1);
        System.out.println(isPalindrome(head2));
        System.out.println(isPalindrome(ListNode.createListNode(1)));
        System.out.println(isPalindrome(ListNode.createListNode(1, 2)));
    }

}
