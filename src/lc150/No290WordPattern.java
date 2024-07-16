package lc150;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No290WordPattern {

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> c2s = new HashMap<>();
        HashMap<String, Character> s2c = new HashMap<>();

        String[] words = s.split(" ");
        char[] patterns = pattern.toCharArray();
        if (words.length != patterns.length) {
            return false;
        }

        for (int i = 0; i < patterns.length; i++) {
            char c = patterns[i];
            String word = words[i];
            if (c2s.containsKey(c) || s2c.containsKey(word)) {
                boolean cond1 = c2s.containsKey(c) && c2s.get(c).equals(word);
                if (!cond1) {
                    return false;
                }
                boolean cond2 = s2c.containsKey(word) && s2c.get(word) == c;
                if (!cond2) {
                    return false;
                }
            } else {
                c2s.put(c, word);
                s2c.put(word, c);
            }
        }
        return true;
    }

}
