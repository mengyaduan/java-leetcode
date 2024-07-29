package lc150;

import DataStruct.ListNode;
import sun.text.normalizer.CharacterIteratorWrapper;

/**
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int x = a + b + flag;
            flag = x / 10;
            ListNode item = new ListNode(x % 10);
            cur.next = item;
            cur = cur.next;
        }
        return preHead.next;
    }

}
