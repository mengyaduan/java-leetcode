package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/insertion-sort-list/description/">链表进行插入排序</a>
 **/
public class No147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(-123);
        preHead.next = head;

        ListNode target = head;
        ListNode preTarget = preHead;
        while (target != null) {
            ListNode pivot = preHead;
            ListNode start = preHead.next;
            while (start.val < target.val) {
                pivot = start;
                start = start.next;
            }
            if (start == target) {
                // 前面所有数字都小于target，更新一下数据进行下一轮
                preTarget = target;
                target = target.next;
            } else {
                // 需要进行插入，tmp为移动的节点
                ListNode tmp = target;
                // 将target前进，便于下一轮处理
                target = target.next;
                // 将tmp挪到pivot后面，同时preTarget连接到target
                preTarget.next = tmp.next;
                tmp.next = pivot.next;
                pivot.next = tmp;
            }
        }
        return preHead.next;
    }

    @Test(description = "")
    public void test1() throws Exception {
        ListNode head = ListNode.createListNode(1);
        System.out.println(insertionSortList(head));
    }

    @Test(description = "")
    public void test2() throws Exception {
        ListNode head = ListNode.createListNode(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        System.out.println(insertionSortList(head));
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(3, 4, 5, 2, 1, 6);
        System.out.println(insertionSortList(head));
    }
}

