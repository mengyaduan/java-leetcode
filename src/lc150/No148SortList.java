package lc150;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No148SortList {

    public ListNode sortList(ListNode head) {
        // 如果是一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中点，拆分成两段
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode part1 = sortList(head);
        ListNode part2 = sortList(head2);

        // merge两段
        ListNode i = part1;
        ListNode j = part2;
        ListNode res = merge(i, j);
        return res;
    }

    private ListNode merge(ListNode i, ListNode j) {
        if (i == null || j == null) {
            return i == null ? j : i;
        }
        ListNode dummy = new ListNode(-1);
        if (i.val <= j.val) {
            dummy.next = i;
            i = i.next;
        } else {
            dummy.next = j;
            j = j.next;
        }
        ListNode cur = dummy.next;
        while (i != null && j != null) {
            if (i.val <= j.val) {
                cur.next = i;
                i = i.next;
            } else {
                cur.next = j;
                j = j.next;
            }
            cur = cur.next;
        }
        cur.next = i == null ? j : i;
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {

        ListNode h1 = ListNode.createListNode(4, 2, 1, 3);
        System.out.println(sortList(h1));

    }

    @Test(description = "")
    public void testMerge() throws Exception {
        ListNode h1 = ListNode.createListNode(1, 3, 5, 6);
        ListNode h2 = ListNode.createListNode(-2, 2, 4, 9);
        System.out.println(merge(h1, h2));
    }
}
