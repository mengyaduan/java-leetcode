package DataStruct;

public class DoubleListNode {
    public DoubleListNode next;
    public DoubleListNode pre;
    public int key;
    public int value;

    public DoubleListNode(int x, int y) {
        key = x;
        value = y;
        next = null;
        pre = null;
    }
}
