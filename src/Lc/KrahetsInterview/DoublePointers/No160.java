package Lc.KrahetsInterview.DoublePointers;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/description/">相交链表</a>
 **/
public class No160 {

    /**
     * 1. 遍历先找到断链表，然后计算出两个链表的差值<p>
     * 2. 从头遍历，如果不一样，则长链表++，同时差值--<p>
     * 3. 当没有差值的时候，两个链表同时前进
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenM = 0;
        int lenN = 0;
        ListNode m = headA;
        ListNode n = headB;
        while (m != null || n != null) {
            if (m != null) {
                m = m.next;
                lenM++;
            }
            if (n != null) {
                n = n.next;
                lenN++;
            }
        }

        ListNode shortOne = headA;
        ListNode longOne = headB;
        int diff = 0;
        if (lenM <= lenN) {
            // A短
            diff = lenN - lenM;
        } else {
            // B短
            diff = lenM - lenN;
            shortOne = headB;
            longOne = headA;
        }
        while (shortOne != null && longOne != null) {
            if (shortOne == longOne) {
                return shortOne;
            } else if (diff > 0) {
                longOne = longOne.next;
                diff--;
            } else if (diff == 0) {
                shortOne = shortOne.next;
                longOne = longOne.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNodeAnswer(ListNode headA, ListNode headB) {
        ListNode m = headA;
        ListNode n = headB;
        while (m != n) {
            m = m == null ? headB : m.next;
            n = n == null ? headA : n.next;
        }
        return m;
    }

    @Test(description = "单测")
    public void test() {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        ListNode c = ListNode.createListNode(3, 4, 5, 6);
        A.next.next = c;

        ListNode B = new ListNode(21);
        B.next = c;


        ListNode x = getIntersectionNodeAnswer(ListNode.createListNode(2, 6, 4), ListNode.createListNode(1, 5));
        System.out.println(x);

    }

}

