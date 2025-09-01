package LC100Again;


import org.testng.annotations.Test;

/**
 * No 054
 */
public class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new Node();
            }
            cur = cur.child[c - 'a'];
            if (i == word.length() - 1) {
                cur.isEnd = true;
            }
        }

    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
            cur = cur.child[c - 'a'];
        }
        return cur.isEnd;
    }


    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
            cur = cur.child[c - 'a'];
        }
        return true;
    }

    class Node {
        Node[] child;
        boolean isEnd;

        Node() {
            child = new Node[26];
            isEnd = false;
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        Trie t = new Trie();
        t.insert("happy");
        t.insert("hello");
        System.out.println(t.search("happ"));
        System.out.println(t.search("happy"));
        System.out.println(t.search("hao"));
        System.out.println(t.startsWith("he"));
        System.out.println(t.startsWith("ha"));
    }
}
