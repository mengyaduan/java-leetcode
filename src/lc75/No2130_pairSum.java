package lc75;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75">链表中的最大孪生和</a>
 */
public class No2130_pairSum {


    public int pairSum(ListNode head) {
        if (head.next != null && head.next.next == null) {
            return head.val + head.next.val;
        }
        // 先找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        //slow就是中点
        ListNode right = reverseList(slow);
        ListNode left = head;

        int res = Integer.MIN_VALUE;
        while (right != null) {
            res = Math.max(res, right.val + left.val);
            right = right.next;
            left = left.next;
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(5, 4, 2, 1);
        System.out.println(pairSum(head));
        head = ListNode.createListNode(4, 2, 2, 3);
        System.out.println(pairSum(head));

    }
}
