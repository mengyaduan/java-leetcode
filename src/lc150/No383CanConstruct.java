package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No383CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (char c : magazine.toCharArray()) {
            int idx = c - 'a';
            letters[idx] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            int idx = c - 'a';
            if (letters[idx] == 0) {
                return false;
            }
            letters[idx] -= 1;
        }
        return true;
    }

}
