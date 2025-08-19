package LC100Again;

import com.sun.scenario.effect.Brightpass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Lc012 {

    public String minWindow(String s, String t) {
        String result = "";
        HashMap<Character, Integer> helper = new HashMap<>();
        // 一共cnt个字符
        for (char c : t.toCharArray()) {
            helper.put(c, helper.getOrDefault(c, 0) + 1);
        }
        int curCnt = 0;
        char[] sc = s.toCharArray();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < sc.length) {
            char item = sc[right];
            if (helper.containsKey(item)) {
                helper.put(item, helper.get(item) - 1);
                if (helper.get(item) == 0) {
                    curCnt++;
                }
            }
            while (curCnt == helper.size()) {
                if (right - left < minLen) {
                    minStart = left;
                    minLen = right - left + 1;
                }
                char cLeft = sc[left];
                if (helper.containsKey(cLeft)) {
                    helper.put(cLeft, helper.get(cLeft) + 1);
                    if (helper.get(cLeft) == 1) {
                        curCnt--;
                    }
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }

}
