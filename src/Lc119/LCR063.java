package Lc119;


import DataStruct.TrieNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR063 {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String pre : dictionary) {
            insert(root, pre);
        }
        ArrayList<String> result = new ArrayList<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String item = getPrefix(root, word);
            result.add(item);
        }
        return String.join(" ", result);
    }

    private String getPrefix(TrieNode root, String word) {
        StringBuilder res = new StringBuilder();
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.isEnd) {
                return res.toString();
            }
            if (cur.child[c - 'a'] == null) {
                break;
            }
            res.append(c);
            cur = cur.child[c - 'a'];
        }
        return word;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
            }
            cur = cur.child[c - 'a'];
        }
        cur.isEnd = true;
    }


    @Test(description = "")
    public void test() throws Exception {
        List<String> dic = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
        System.out.println(replaceWords(dic, "the cattle was rattled by the battery"));

    }
}
