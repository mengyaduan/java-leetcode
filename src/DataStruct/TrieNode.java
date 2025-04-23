package DataStruct;


public class TrieNode {
    public TrieNode[] child;
    public boolean isEnd;

    public TrieNode() {
        this.child = new TrieNode[26];
        this.isEnd = false;
    }
}
