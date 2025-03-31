package Lc119;

public class LCR032 {

    public boolean isAnagram(String s, String t) {
        if (s.equals(t) || s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[26];
        int cnt = 0;
        for (char item : s.toCharArray()) {
            int idx = item - 'a';
            letters[idx]++;
            if (letters[idx] == 1) {
                cnt++;
            }
        }
        for (char item : t.toCharArray()) {
            int idx = item - 'a';
            letters[idx]--;
            if (letters[idx] == 0) {
                cnt--;
            }
            if (letters[idx] < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

}
