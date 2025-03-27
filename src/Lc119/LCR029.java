package Lc119;

public class LCR029 {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            // 如果head是null
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        if (head.next == head) {
            // 如果原来是单节点
            Node item = new Node(insertVal);
            head.next = item;
            item.next = head;
            return head;
        }
        // 如果是多节点，那么定位两个节点（l，r），
        Node left = head;
        Node right = head.next;
        boolean finished = false;
        while (!finished) {
            // 一共三种场景需要插入:
            //场景一： 1,2,3,5  如果插入4，则找 l<=target<=r
            boolean needInsert = left.val <= insertVal && insertVal <= right.val;
            //场景二： 2,3,4  如果插入1 或 8， 则找 l>r && (target >= l || target <= r)
            needInsert |= left.val > right.val && (insertVal >= left.val || insertVal <= right.val);
            //场景三： 3,3,3,3 插入0; 已经走完一圈了，还没有插入，此时只可能插在r和r.next中间了
            if (!needInsert && right == head) {
                // 这种场景下，需要单独设置left和right
                left = right;
                right = right.next;
                needInsert = true;
            }
            if (needInsert) {
                Node item = new Node(insertVal);
                item.next = right;
                left.next = item;
                finished = true;
            }
            left = left.next;
            right = right.next;
        }
        return head;
    }

}
