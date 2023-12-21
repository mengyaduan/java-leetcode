package Lc.KrahetsInterview.LinkedList;

import org.testng.annotations.Test;

import static Lc.KrahetsInterview.LinkedList.Node.createNode;

/**
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/">复制随机链表</a>
 **/
public class No138 {


    public Node copyRandomList(Node head) {
        // 先复制一遍
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node headNew = new Node(head.val);
        Node curNew = headNew;
        cur = cur.next;
        while (cur != null) {
            curNew.next = new Node(cur.val);
            curNew = curNew.next;
            cur = cur.next;
        }
        // ori指向原来的
        curNew = headNew;
        cur = head;
        while (cur != null) {
            // 遍历
            Node indexOri = head;
            Node indexNew = headNew;
            while (indexOri != null) {
                if (indexOri.random != null && indexOri.random == cur) {
                    // 如果index指向了cur，那么indexNew就得指向curNew
                    indexNew.random = curNew;
                }
                indexOri = indexOri.next;
                indexNew = indexNew.next;
            }
            curNew = curNew.next;
            cur = cur.next;
        }
        return headNew;
    }

    @Test(description = "单测")
    public void test() {
        Node head = createNode(new int[]{1, 5}, new int[]{2, 3}, new int[]{3, -100001}, new int[]{4, 4}, new int[]{5, 2});
        System.out.println(head);
        Node headNew = copyRandomList(head);
        System.out.println(headNew);
    }

}

