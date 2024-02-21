package Lc.divideandconquer;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">合并K个有序链表</a>
 **/
public class No23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        if (k == 1) {
            return lists[0];
        }
        int size = k % 2 == 0 ? k / 2 : k / 2 + 1;
        ListNode[] lNew = new ListNode[size];
        for (int i = 0; i < size; i++) {
            if (i != lists.length - 1 - i) {
                lNew[i] = mergeTwo(lists[i], lists[lists.length - 1 - i]);
            } else {
                lNew[i] = lists[i];
            }
        }
        return mergeKLists(lNew);
    }

    public ListNode mergeTwo(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        while (true) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
            if (head1 == null || head2 == null) {
                // 任意一个为空时，将另一个剩余的追加进来就可以返回了
                cur.next = head1 == null ? head2 : head1;
                break;
            }
        }
        return head.next;
    }

    @Test(description = "")
    public void testMergeTwo() throws Exception {
        ListNode head1 = ListNode.createListNode(1, 3, 5, 7);
        ListNode head2 = ListNode.createListNode(0, 2, 4, 5, 8);
        ListNode head3 = null;
        ListNode head4 = ListNode.createListNode(1, 1, 1, 1, 1, 1);
        System.out.println(mergeTwo(head1, head2));
        System.out.println(mergeTwo(head1, head3));
        System.out.println(mergeTwo(head4, head3));
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head1 = ListNode.createListNode(1, 3, 5, 7);
        ListNode head2 = ListNode.createListNode(0, 2, 4, 5, 8);
        ListNode head3 = null;
        ListNode head4 = ListNode.createListNode(1, 1, 1, 1, 1, 1);
        ListNode[] lists = new ListNode[]{head1, head2, head3, head4};
        System.out.println(mergeKLists(lists));
    }

}

