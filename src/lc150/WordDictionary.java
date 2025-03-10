package lc150;

import org.testng.annotations.Test;

/**
 * No211
 */
public class WordDictionary {

    WNode root;

    public WordDictionary() {
        root = new WNode();
    }

    public void addWord(String word) {
        char[] w = word.toCharArray();
        WNode cur = root;
        for (char c : w) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new WNode();
            }
            cur = cur.child[c - 'a'];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        return searchWithDot(word, 0, root);
    }

    private boolean searchWithDot(String s, int idx, WNode cur) {
        if (idx == s.length() && cur != null) {
            return cur.isLeaf;
        }
        if (cur == null) {
            return false;
        }

        if (s.charAt(idx) == '.') {
            for (int i = 0; i < 26; i++) {
                boolean res = searchWithDot(s, idx + 1, cur.child[i]);
                if (res) {
                    return true;
                }
            }
        } else {
            // 非通配符，直接看下一个
            return searchWithDot(s, idx + 1, cur.child[s.charAt(idx) - 'a']);
        }
        return false;
    }

    class WNode {
        boolean isLeaf;
        WNode[] child;

        WNode() {
            this.isLeaf = false;
            this.child = new WNode[26];
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("pad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("pa"));
        System.out.println(wordDictionary.search("pa."));
        System.out.println(wordDictionary.search("p.d"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("p.."));

    }
}
