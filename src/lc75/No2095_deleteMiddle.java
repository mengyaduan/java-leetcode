package lc75;

import DataStruct.ListNode;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75">删除中间节点</a>
 */
public class No2095_deleteMiddle {

    public ListNode deleteMiddle(ListNode head) {
        if (head==null || head.next == null) {
            return null;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        // 此时slow就是中间节点了
        pre.next = slow.next;
        return head;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 3, 4, 7, 1, 2, 6);
        System.out.println(deleteMiddle(head));
        head = ListNode.createListNode(2, 1);
        System.out.println(deleteMiddle(head));
        head = ListNode.createListNode(1, 2, 3, 4);
        System.out.println(deleteMiddle(head));
    }

}
