package LcSpring100;

import java.util.Arrays;

public class No387FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] idxFirst = new int[26];
        Arrays.fill(idxFirst, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (idxFirst[idx] == -1) {
                idxFirst[idx] = i;
            } else if (idxFirst[idx] >= 0) {
                idxFirst[idx] = -2;
            }
        }
        int result = -1;
        for (int i = 0; i < idxFirst.length; i++) {
            if (idxFirst[i] >= 0) {
                result = result < 0 ? idxFirst[i] : Math.min(result, idxFirst[i]);
            }
        }
        return result;
    }
}
