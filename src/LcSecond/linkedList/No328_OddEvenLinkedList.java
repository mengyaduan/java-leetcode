package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/odd-even-linked-list/description/">奇偶链表</a>
 **/
public class No328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastOdd = head;
        int count = 2;
        ListNode cur = head.next;
        ListNode lastEven = cur;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            if (count % 2 == 1) {
                lastEven.next = tmp.next;
                lastEven = lastEven.next;
                tmp.next = lastOdd.next;
                lastOdd.next = tmp;
                lastOdd = lastOdd.next;
            }
            count++;
       }
        return head;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(oddEvenList(head));

    }
}
