package Lc.linkedlist;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/description/">翻转列表</a>
 **/
public class No206_ReverseList {


    /**
     * 迭代
     **/
    public ListNode reverseList(ListNode head) {
        ListNode headNew = new ListNode();
        ListNode cur = headNew;
        ListNode tmp = null;
        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = cur.next;
            cur.next = tmp;
        }
        return headNew.next;
    }

    /**
     * 递归
     **/
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNew = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return headNew;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseListRecursion(head));

        head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseList(head));

    }
}


