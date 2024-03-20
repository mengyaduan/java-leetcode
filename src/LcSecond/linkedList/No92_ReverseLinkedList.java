package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/description/">翻转链表的指定区间</a>
 **/
public class No92_ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = right - left;
        if (count == 0) {
            return head;
        }
        ListNode pre = new ListNode(-1), suf = null;
        pre.next = head;
        ListNode leftNode = head;
        int m = 1;
        while (left != m) {
            pre = leftNode;
            leftNode = leftNode.next;
            m++;
        }
        suf = leftNode;
        while (count > 0) {
            ListNode tmp = leftNode.next;
            leftNode.next = tmp.next;
            pre.next = tmp;
            tmp.next = suf;
            suf = tmp;
            count--;
        }
        return left == 1 ? pre.next : head;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(reverseBetween(head, 2, 4));
        ListNode head2 = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(reverseBetween(head2, 2, 3));
        ListNode head3 = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(reverseBetween(head3, 1, 3));

    }
}

