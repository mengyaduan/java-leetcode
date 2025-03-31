package DataStruct;

public class DoubleListNode {
    public DoubleListNode next;
    public DoubleListNode pre;
    public int key;
    public int value;

    public DoubleListNode(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        pre = null;
    }
}
