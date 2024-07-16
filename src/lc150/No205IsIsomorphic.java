package lc150;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No205IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            char sc = sArr[i];
            char tc = tArr[i];
            if (s2t.containsKey(sc) || t2s.containsKey(tc)) {
                // 任意一个已经有过映射关系了，那么映射关系必须一致，否则就不是同构
                boolean cond1 = s2t.containsKey(sc) && s2t.get(sc) == tc;
                boolean cond2 = t2s.containsKey(tc) && t2s.get(tc) == sc;
                if (!(cond1 && cond2)) {
                    return false;
                }
            } else {
                s2t.put(sc, tc);
                t2s.put(tc, sc);
            }
        }
        return true;
    }

}
