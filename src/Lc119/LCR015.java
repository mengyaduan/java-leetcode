package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LCR015 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        HashMap<Character, Integer> helper = new HashMap<>();
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();
        for (char c : pc) {
            if (!helper.containsKey(c)) {
                cnt++;
            }
            helper.put(c, helper.getOrDefault(c, 0) + 1);
        }
        int left = 0, winSize = p.length();
        for (int right = 0; right < s.length(); right++) {
            char r = sc[right];
            if (helper.containsKey(r)) {
                helper.put(r, helper.get(r) - 1);
                if (helper.get(r) == 0) {
                    cnt--;
                }
            }
            if (right - left + 1 > winSize) {
                char l = sc[left];
                if (helper.containsKey(l)) {
                    helper.put(l, helper.get(l) + 1);
                    if (helper.get(l) == 1) {
                        cnt++;
                    }
                }
                left++;
            }
            if (right - left + 1 == winSize && cnt == 0) {
                result.add(left);
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));

    }
}
