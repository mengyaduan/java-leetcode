package lc100;

import DataStruct.ListNode;
import Lc.KrahetsInterview.LinkedList.Node;

import java.util.HashMap;

public class No138 {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> helper = new HashMap<>();
        Node dummy = new Node(-1);
        Node pre = dummy;
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            helper.put(cur, tmp);
            pre.next = tmp;
            pre = pre.next;
            cur = cur.next;
        }
        cur = head;
        Node curCopy = dummy.next;
        while (cur != null) {
            curCopy.random = helper.get(cur.random);
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return dummy.next;
    }

}
