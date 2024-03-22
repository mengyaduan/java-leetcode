package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/reorder-list/description/">重排链表</a>
 **/
public class No143_ReorderList {
    public void reorderList(ListNode head) {
        reorder(head);
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode headNew = head.next;
        ListNode cur = head.next;
        ListNode preCur = head;
        while (cur.next != null) {
            preCur = cur;
            cur = cur.next;
        }
        preCur.next = null;
        head.next = cur;
        cur.next = reorder(headNew);
        return head;
    }

    @Test(description = "")
    public void test2() throws Exception {
        ListNode head = ListNode.createListNode(1);
        reorderList(head);
        System.out.println(head);
    }

    @Test(description = "")
    public void test1() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        reorderList(head);
        System.out.println(head);
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        reorderList(head);
        System.out.println(head);
    }

}
