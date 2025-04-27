package Lc119;

import DataStruct.TrieNode;
import sun.awt.IconInfo;

public class MagicDictionary {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                }
                cur = cur.child[c - 'a'];
            }
            cur.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        // 逐位遍历
        char[] sc = searchWord.toCharArray();
        for (int idx = 0; idx < sc.length; idx++) {
            char now = sc[idx];
            for (int i = 0; i < 26; i++) {
                char replace = (char) ('a' + i);
                if (replace == now) {
                    continue;
                }
                sc[idx] = replace;
                if (searchAll(new String(sc))) {
                    return true;
                }
            }
            // 复位
            sc[idx] = now;
        }
        return false;
    }

    public boolean searchAll(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
            cur = cur.child[c - 'a'];
        }
        return cur.isEnd;
    }

}

