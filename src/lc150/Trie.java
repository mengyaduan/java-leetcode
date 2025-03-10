package lc150;

import org.testng.annotations.Test;

/**
 * No 208
 */
public class Trie {

    TNode root;

    public Trie() {
        root = new TNode();
    }

    public void insert(String word) {
        TNode cur = root;
        for (int i = 0; i < word.toCharArray().length; i++) {
            char item = word.toCharArray()[i];
            int idx = item - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new TNode();
            }
            cur = cur.child[idx];
            if (i == word.length() - 1) {
                // 已经到了最后一个
                cur.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        TNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char item = word.charAt(i);
            int idx = item - 'a';
            if (cur.child[idx] == null) {
                return false;
            }
            cur = cur.child[idx];
            if (i == word.length() - 1) {
                return cur.isLeaf;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char item = prefix.charAt(i);
            int idx = item - 'a';
            if (cur.child[idx] == null) {
                return false;
            }
            cur = cur.child[idx];
        }
        return true;

    }


    class TNode {
        boolean isLeaf;
        TNode[] child;

        TNode() {
            isLeaf = false;
            child = new TNode[26];
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startsWith("ab"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.search("abcd"));
        System.out.println();
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        System.out.println(trie.search("abcd"));
        System.out.println();
        trie.insert("abcd");
        System.out.println(trie.search("abcd"));

    }

}
