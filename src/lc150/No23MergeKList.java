package lc150;

import DataStruct.ListNode;

public class No23MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int i = 0, j = lists.length - 1;
        while (true) {
            if (j == 0) {
                break;
            }
            if (i >= j) {
                // 奇数长度，此时将i归零，继续合并
                i = 0;
            }
            lists[i] = mergeTwo(lists[i], lists[j]);
            i++;
            j--;
        }
        return lists[0];
    }

    private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
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
        return dummy.next;
    }


}
