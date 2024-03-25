package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/">交换第k个节点和倒数第k个节点的位置</a>
 **/
public class No1721_SwappingNodes {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        int count = 1;

        ListNode dummy = new ListNode(123);
        dummy.next = head;
        ListNode preLeft = dummy;
        ListNode preRight = dummy;
        while (cur != null) {
            if (count <= k - 1) {
                preLeft = preLeft.next;
            }
            if (count >= k + 1) {
                preRight = preRight.next;
            }
            cur = cur.next;
            count++;
        }
        ListNode right = preRight.next;
        ListNode left = preLeft.next;
        // 场景1： preLeft， preRight，right ，left 是四个节点，直接交换
        // 场景2： preLeft=right 或者 preRight = left
        if (preLeft == right) {
            preRight.next = left;
            preLeft.next = left.next;
            left.next = preLeft;
        } else if (preRight == left) {
            preLeft.next = right;
            preRight.next = right.next;
            right.next = preRight;
        } else {
            preLeft.next = right;
            preRight.next = left;
            ListNode tmp = left.next;
            left.next = right.next;
            right.next = tmp;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(swapNodes(ListNode.createListNode(1, 2, 3, 4, 5, 6), 4));
        System.out.println(swapNodes(ListNode.createListNode(1, 2), 2));

        ListNode x = swapNodes(ListNode.createListNode(7, 9, 6, 6, 7, 8, 3, 0, 9, 5), 6);
        System.out.println(x);

        ListNode y = swapNodes(ListNode.createListNode(1, 2, 3, 4, 5, 6, 7, 8, 9), 6);
        System.out.println(y);
    }
}
