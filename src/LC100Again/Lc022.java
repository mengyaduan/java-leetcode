package LC100Again;


import DataStruct.ListNode;
import org.testng.annotations.Test;

public class Lc022 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        boolean change1 = true, change2 = true;
        while (h1 != h2) {
            if (h1.next == null && change1) {
                change1 = false;
                h1 = headB;
            } else {
                h1 = h1.next;
            }
            if (h2.next == null && change2) {
                change2 = false;
                h2 = headA;
            } else {
                h2 = h2.next;
            }
        }
        return h1;
    }

    /**
     * 优雅 永不过时
     */
    public ListNode getIntersectionNodeBeautiful(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode x = ListNode.createListNode(2, 6, 4);
        ListNode y = ListNode.createListNode(5, 1);
        y.next.next = x.next.next;

        ListNode z = getIntersectionNode(x, y);
        if (z != null) {
            System.out.println(z.val);
        }

    }

}
