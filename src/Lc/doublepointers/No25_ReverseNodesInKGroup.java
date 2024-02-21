package Lc.doublepointers;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/description/"></a>
 **/
public class No25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode[] toBeReversed = new ListNode[k];
        ListNode cur = head;
        ListNode res = null;
        ListNode joinPoint = null;
        while (true) {
            boolean flagBreak = false;
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    flagBreak = true;
                    break;
                }
                toBeReversed[i] = cur;
                cur = cur.next;
            }
            if (flagBreak) {
                break;
            }
            // 1→2→3→4→5→6，假设k=5，那么数组里面是1，2，3，4，5
            // 接下来将5和1,2,3,4调换，就变成了 5,4,3,2,1,6
            for (int i = 0; i < k - 1; i++) {
                toBeReversed[i].next = toBeReversed[k - 1].next;
                toBeReversed[k - 1].next = toBeReversed[i];
            }
            res = res == null ? toBeReversed[k - 1] : res;
            // 链接点非空的时候，都需要连上
            if (joinPoint != null) {
                joinPoint.next = toBeReversed[k - 1];
            }
            cur = toBeReversed[0].next;
            joinPoint = toBeReversed[0];
            // 清空toBeReversed，开始下一轮
            Arrays.fill(toBeReversed, null);
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseKGroup(head, 4));
        head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseKGroup(head, 3));
        head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseKGroup(head, 2));
        head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseKGroup(head, 1));

    }
}

