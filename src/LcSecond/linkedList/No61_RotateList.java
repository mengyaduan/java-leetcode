package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/rotate-list/description/">旋转链表</a>
 **/
public class No61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        ListNode cur = head;
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        int kk = k % size;
        cur = head;
        ListNode pre = head;
        while (cur.next != null) {
            if (kk > 0) {
                kk--;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        cur.next = head;
        res = pre.next;
        pre.next = null;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(rotateRight(head, 1));
        head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(rotateRight(head, 2));

    }
}
