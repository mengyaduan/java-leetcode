package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class LCR078 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n < 2) {
            return n == 0 ? null : lists[0];
        }
        int j = n - 1;
        while (j > 0) {
            j = mergeN(lists, j);
        }
        return lists[0];
    }

    private int mergeN(ListNode[] lists, int j) {
        int i = 0;
        while (i < j) {
            ListNode item = merge(lists[i], lists[j]);
            lists[i] = item;
            i++;
            j--;
        }
        return j;
    }

    private ListNode merge(ListNode head, ListNode head1) {
        ListNode result = new ListNode();
        ListNode cur = result;
        while (head != null && head1 != null) {
            if (head.val <= head1.val) {
                cur.next = head;
                head = head.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head == null ? head1 : head;
        return result.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(mergeKLists(new ListNode[]{ListNode.createListNode(8), ListNode.createListNode(3), ListNode.createListNode(1)}));

    }


}
