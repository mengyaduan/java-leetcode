package lc75;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75">奇偶链表</a>
 */
public class No328_oddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            // 节点小于3个，都不处理
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        int step = 1;
        while (true) {
            int move = step;
            ListNode cur = even;
            ListNode pre = odd;
            while (cur != null && move > 0) {
                pre = cur;
                cur = cur.next;
                move--;
            }
            if (cur == null) {
                // 再也没有奇数了
                return head;
            } else {
                step++;
                // 将even挪到odd后面，同时移动odd
                pre.next = cur.next;
                odd.next = cur;
                cur.next = even;
                odd = odd.next;
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(oddEvenList(head));
        head = ListNode.createListNode(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(oddEvenList(head));

    }
}
