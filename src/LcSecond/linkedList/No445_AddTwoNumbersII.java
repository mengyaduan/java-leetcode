package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers-ii/description/"> 两数之和 ii</a>
 **/
public class No445_AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> n1 = new Stack<>();
        Stack<Integer> n2 = new Stack<>();
        while (l1 != null) {
            n1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            n2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int flag = 0;
        while (!n1.isEmpty() || !n2.isEmpty()) {
            int num1 = n1.isEmpty() ? 0 : n1.pop();
            int num2 = n2.isEmpty() ? 0 : n2.pop();
            int item = (num1 + num2 + flag);
            ListNode cur = new ListNode(item % 10);
            flag = item >= 10 ? 1 : 0;
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
        }
        if (flag>0){
            ListNode cur = new ListNode(flag);
            cur.next = head;
            return cur;
        }
        return head;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(addTwoNumbers(ListNode.createListNode(7, 2, 4, 3), ListNode.createListNode(5, 6, 4)));

    }
}
