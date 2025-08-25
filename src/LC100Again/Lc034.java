package LC100Again;


import DataStruct.ListNode;
import org.testng.annotations.Test;

public class Lc034 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int j = lists.length - 1;
        while (j > 0) {
            j = merge2(lists, 0, j);
        }
        return lists[0];
    }

    private int merge2(ListNode[] lists, int i, int j) {
        while (i < j) {
            ListNode h1 = lists[i], h2 = lists[j];
            ListNode dummy = new ListNode(), pre = dummy;
            while (h1 != null && h2 != null) {
                if (h1.val <= h2.val) {
                    pre.next = h1;
                    h1 = h1.next;
                } else {
                    pre.next = h2;
                    h2 = h2.next;
                }
                pre = pre.next;
            }
            pre.next = h1 == null ? h2 : h1;
            lists[i] = dummy.next;
            i++;
            j--;
        }
        return j;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode h1 = ListNode.createListNode(1, 3, 4, 6, 9, 21);
        ListNode h2 = ListNode.createListNode(2, 5, 7, 8, 19);
        ListNode h3 = ListNode.createListNode(11, 15, 17, 35);
        System.out.println(mergeKLists(new ListNode[]{h1, h2, h3, null}));


    }


}
