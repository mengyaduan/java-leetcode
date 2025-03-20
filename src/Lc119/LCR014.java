package Lc119;

import org.testng.annotations.Test;

import java.util.HashMap;

public class LCR014 {


    public boolean checkInclusion(String s1, String s2) {
        int winSize = s1.length();
        int cnt = 0;
        HashMap<Character, Integer> helper = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (!helper.containsKey(c)) {
                cnt++;
            }
            helper.put(c, helper.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            // 直接扩张，如果超过，则缩小，然后判断
            char item = s2.charAt(right);
            if (helper.containsKey(item)) {
                helper.put(item, helper.get(item) - 1);
                if (helper.get(item) == 0) {
                    cnt--;
                }
            }
            // 计算是否需要收缩
            if (right - left + 1 > winSize) {
                // 收缩
                char tmp = s2.charAt(left);
                if (helper.containsKey(tmp)) {
                    helper.put(tmp, helper.get(tmp) + 1);
                    if (helper.get(tmp) == 1) {
                        cnt++;
                    }
                }
                left++;
            }
            if (right - left + 1 == winSize && cnt == 0) {
                return true;
            }
        }
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(checkInclusion("ab", "dkjfibaiue"));
        System.out.println(checkInclusion("ab", "dkjfibxaiue"));

    }

}
