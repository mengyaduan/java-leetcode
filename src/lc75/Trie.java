package lc75;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=leetcode-75">实现Trie</a>
 */
public class Trie {

    HashMap<Character, ArrayList<String>> dict;

    public Trie() {
        dict = new HashMap<>();
    }

    public void insert(String word) {
        char k = word.charAt(0);
        if (!dict.containsKey(k)) {
            dict.put(k, new ArrayList<>());
        }
        if (dict.get(k).contains(word)) {
            return;
        }
        dict.get(k).add(word);
    }

    public boolean search(String word) {
        char k = word.charAt(0);
        if (!dict.containsKey(k)) {
            return false;
        }
        ArrayList<String> words = dict.get(k);
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        char k = prefix.charAt(0);
        if (!dict.containsKey(k)) {
            return false;
        }
        ArrayList<String> words = dict.get(k);
        for (String item : words) {
            if (item.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

}
