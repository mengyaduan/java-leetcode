package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/sort-list/description/">链表排序</a>
 **/
public class No148_SortList {


    public ListNode sortList(ListNode head) {
        // 归并排序
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            if (head.val > head.next.val) {
                head.next.next = head;
                head = head.next;
                head.next.next = null;
            }
            return head;
        }

        // 先分成两个链表进行归并
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode h1 = sortList(head);
        h2 = sortList(h2);
        // 排序好的两个链表合并
        return merge(h1, h2);
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        ListNode result;
        ListNode a, b;
        if (h1.val <= h2.val) {
            result = h1;
            a = h1.next;
            b = h2;
        } else {
            result = h2;
            a = h2.next;
            b = h1;
        }
        ListNode cur = result;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a == null ? b : a;
        return result;
    }


    @Test(description = "")
    public void test1() throws Exception {
        ListNode h1 = ListNode.createListNode(1, 3, 5, 7, 8, 9);
        ListNode h2 = ListNode.createListNode(2, 4, 5, 6, 10, 12);
        System.out.println(merge(h1, h2));
    }

    public ListNode sortListQS(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-123);
        dummy.next = head;
        int pivot = head.val;
        ListNode pre = head;
        ListNode cur = head.next;
        // 遍历链表，把小于head的往前挪，大于head的不动
        while (cur != null) {
            if (cur.val >= pivot) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode tmp = cur;
                cur = cur.next;
                pre.next = cur;
                tmp.next = dummy.next;
                dummy.next = tmp;
            }
        }
        // 走完一遍，pivot的值就正确了，接下来拆分两个链表
        ListNode h1 = dummy.next;
        ListNode h2 = head.next;
        head.next = null;
        dummy.next = sortListQS(h1);
        head.next = sortListQS(h2);
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
//        ListNode head = ListNode.createListNode(3, 1);
        System.out.println(sortList(head));
    }


}

