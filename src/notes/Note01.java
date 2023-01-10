package notes;

import Lc.ListNode;
import org.testng.annotations.Test;

/**
 * 测试一下单链表和前序后序遍历
 **/
public class Note01 {

    public void function(ListNode head) {

    }

    public void transferForward(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        transferForward(head.next);
    }

    public void transferBackward(ListNode head) {
        if (head == null) {
            return;
        }
        transferBackward(head.next);
        // 后序
        System.out.println(head.val);
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("前序遍历：");
        transferForward(head);

        System.out.println("后序遍历：");
        transferBackward(head);

    }


}
