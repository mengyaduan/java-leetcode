package LC100Again;


import DataStruct.ListNode;

public class Lc028 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int c = a + b + carry;
            carry = c / 10;
            ListNode item = new ListNode(c % 10);
            cur.next = item;
            cur = cur.next;
        }
        return dummy.next;
    }

}
