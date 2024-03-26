package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">翻转链表</a>
 **/
public class No206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next;
        ListNode newHead = reverseList(head.next);
        tail.next = head;
        head.next = null;
        return newHead;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseList(head));

        head = ListNode.createListNode(1 );
        System.out.println(reverseList(head));
    }

}
