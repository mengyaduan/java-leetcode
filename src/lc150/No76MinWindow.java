package lc150;

import org.testng.annotations.Test;

import java.util.HashMap;

public class No76MinWindow {

    public String minWindow(String s, String t) {
        String result = "";
        HashMap<Character, Integer> helper = new HashMap<>();
        for (char c : t.toCharArray()) {
            helper.put(c, helper.getOrDefault(c, 0) + 1);
        }
        int cnt = helper.keySet().size();
        int left = 0, right = 0;
        boolean justShrink = false;
        while (left + t.length() <= s.length()) {
            if (cnt == 0 || justShrink) {
                // 记录结果
                if (cnt == 0 && (result.isEmpty() || right - left < result.length())) {
                    result = s.substring(left, right);
                }
                // 缩小左边界
                char item = s.charAt(left);
                if (helper.containsKey(item)) {
                    helper.put(item, helper.get(item) + 1);
                    if (helper.get(item) == 1) {
                        cnt++;
                    }
                }
                left += 1;
            } else {
                if (right == s.length()) {
                    justShrink = true;
                    continue;
                }
                // 扩大右边界
                char item = s.charAt(right);
                if (helper.containsKey(item)) {
                    helper.put(item, helper.get(item) - 1);
                    if (helper.get(item) == 0) {
                        cnt--;
                    }
                }
                right += 1;
            }
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }
}
