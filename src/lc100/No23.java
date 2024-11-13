package lc100;

import DataStruct.ListNode;

public class No23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        int i = 0, j = n - 1;
        while (!(i == j && i == 0)) {
            if (i >= j) {
                i = 0;
                continue;
            }
            lists[i] = mergeTwoSortedList(lists[i], lists[j]);
            i++;
            j--;
        }
        return lists[0];
    }

    private ListNode mergeTwoSortedList(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                pre.next = h2;
                break;
            } else if (h2 == null) {
                pre.next = h1;
                break;
            } else {
                if (h1.val <= h2.val) {
                    pre.next = h1;
                    h1 = h1.next;
                } else {
                    pre.next = h2;
                    h2 = h2.next;
                }
                pre = pre.next;
            }
        }
        return dummy.next;
    }

}
