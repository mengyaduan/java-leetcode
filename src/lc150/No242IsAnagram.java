package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No242IsAnagram {

    public boolean isAnagram(String s, String t) {

        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
        }
        for (int val : letters){
            if (val!=0){
                return false;
            }
        }
        return true;
    }
}
