package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/design-linked-list/description/">实现链表</a>
 **/
public class MyLinkedList {

    ListNode dummy;
    ListNode tail;
    int size;

    public MyLinkedList() {
        dummy = new ListNode(123);
        this.size = 0;
    }

    public int get(int index) {
        int count = 0;
        ListNode cur = dummy;
        while (cur != null && count <= index) {
            cur = cur.next;
            count++;
        }
        return cur == null ? -1 : cur.val;
    }

    public void addAtHead(int val) {
        ListNode item = new ListNode(val);
        item.next = dummy.next;
        dummy.next = item;
        if (item.next == null) {
            // 如果尾指针没有初始化，则更新尾指针
            tail = item;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (tail != null) {
            // 尾指针存在
            tail.next = new ListNode(val);
            tail = tail.next;
            size++;
        } else {
            // 尾指针不存在：一定是全空的时候，直接调用addHead就行了
            addAtHead(val);
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode cur = dummy;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        // 将新节点插入到cur后面
        ListNode item = new ListNode(val);
        item.next = cur.next;
        cur.next = item;
        if (cur == tail) {
            tail = cur.next;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode cur = dummy;
        ListNode pre = null;
        int count = index;
        while (count >= 0) {
            pre = cur;
            cur = cur.next;
            count--;
        }
        pre.next = cur.next;
        if (index == size - 1) {
            // 更新尾指针
            tail = pre;
        }
        size--;
    }


    @Test(description = "")
    public void test123() throws Exception {
        MyLinkedList a = new MyLinkedList();
        ArrayList<String> cmds = new ArrayList<>(Arrays.asList("addAtHead", "addAtTail", "addAtTail", "get", "get", "addAtTail", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "get", "addAtHead", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "get", "deleteAtIndex", "addAtTail", "addAtTail", "addAtHead", "addAtTail", "get", "deleteAtIndex", "addAtTail", "addAtHead", "addAtTail", "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "deleteAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtHead", "addAtHead", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtTail", "get", "addAtHead", "get", "addAtTail", "get", "addAtTail", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "get", "addAtIndex", "get", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtTail", "addAtTail", "addAtHead", "get", "addAtTail", "addAtHead", "addAtTail", "get", "addAtIndex"));
        int[][] tmps = new int[][]{
                new int[]{84}, new int[]{2}, new int[]{39}, new int[]{3}, new int[]{1}, new int[]{42}, new int[]{1, 80}, new int[]{14}, new int[]{1}, new int[]{53}, new int[]{98}, new int[]{19}, new int[]{12}, new int[]{2}, new int[]{16}, new int[]{33}, new int[]{4, 17}, new int[]{6, 8}, new int[]{37}, new int[]{43}, new int[]{11}, new int[]{80}, new int[]{31}, new int[]{13, 23}, new int[]{17}, new int[]{4}, new int[]{10, 0}, new int[]{21}, new int[]{73}, new int[]{22}, new int[]{24, 37}, new int[]{14}, new int[]{97}, new int[]{8}, new int[]{6}, new int[]{17}, new int[]{50}, new int[]{28}, new int[]{76}, new int[]{79}, new int[]{18}, new int[]{30}, new int[]{5}, new int[]{9}, new int[]{83}, new int[]{3}, new int[]{40}, new int[]{26}, new int[]{20, 90}, new int[]{30}, new int[]{40}, new int[]{56}, new int[]{15, 23}, new int[]{51}, new int[]{21}, new int[]{26}, new int[]{83}, new int[]{30}, new int[]{12}, new int[]{8}, new int[]{4}, new int[]{20}, new int[]{45}, new int[]{10}, new int[]{56}, new int[]{18}, new int[]{33}, new int[]{2}, new int[]{70}, new int[]{57}, new int[]{31, 24}, new int[]{16, 92}, new int[]{40}, new int[]{23}, new int[]{26}, new int[]{1}, new int[]{92}, new int[]{3, 78}, new int[]{42}, new int[]{18}, new int[]{39, 9}, new int[]{13}, new int[]{33, 17}, new int[]{51}, new int[]{18, 95}, new int[]{18, 33}, new int[]{80}, new int[]{21}, new int[]{7}, new int[]{17, 46}, new int[]{33}, new int[]{60}, new int[]{26}, new int[]{4}, new int[]{9}, new int[]{45}, new int[]{38}, new int[]{95}, new int[]{78}, new int[]{54}, new int[]{42, 86}
        };
        for (int i = 0; i < cmds.size(); i++) {
            if (cmds.get(i).equals("addAtHead")) {
                a.addAtHead(tmps[i][0]);
            }
            if (cmds.get(i).equals("addAtTail")) {
                a.addAtTail(tmps[i][0]);
            }
            if (cmds.get(i).equals("get")) {
                System.out.println(a.get(tmps[i][0]));
            }
            if (cmds.get(i).equals("addAtIndex")) {
                a.addAtIndex(tmps[i][0], tmps[i][1]);
            }
            if (cmds.get(i).equals("deleteAtIndex")) {
                a.deleteAtIndex(tmps[i][0]);
            }
        }
    }

    @Test(description = "")
    public void test1() throws Exception {
        MyLinkedList a = new MyLinkedList();
        a.addAtHead(7);
        a.addAtHead(2);
        a.addAtHead(1);
        a.addAtIndex(3, 0);
        System.out.println(a.dummy.next);
        a.deleteAtIndex(2);
        a.addAtHead(6);
        a.addAtTail(4);
        System.out.println(a.get(4));
        a.addAtHead(4);
        a.addAtIndex(5, 0);
        a.addAtHead(6);
        System.out.println(a.dummy.next);


    }

    @Test(description = "")
    public void test() throws Exception {
        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(1);
        System.out.println(ml.dummy.next);
        ml.addAtTail(3);
        System.out.println(ml.dummy.next);
        ml.addAtIndex(1, 2);
        System.out.println(ml.dummy.next);
        System.out.println(ml.get(1));
        ml.deleteAtIndex(1);
        System.out.println(ml.get(1));

    }
}
