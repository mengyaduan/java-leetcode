package Lc119;

import org.testng.annotations.Test;

import java.util.HashMap;

public class LCR017 {

    public String minWindow(String s, String t) {
        String result = "";
        if (s.length() < t.length()) {
            return result;
        }
        // 初始化模板数据
        int cnt = 0;
        HashMap<Character, Integer> helper = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!helper.containsKey(c)) {
                cnt++;
            }
            helper.put(c, helper.getOrDefault(c, 0) + 1);
        }
        // 滑动窗口
        int left = 0;
        char[] sc = s.toCharArray();
        for (int right = 0; right < sc.length; right++) {
            char item = sc[right];
            if (helper.containsKey(item)) {
                int beforeExpand = helper.get(item);
                helper.put(item, beforeExpand - 1);
                if (beforeExpand == 1) {
                    cnt--;
                }
            }
            // 当cnt=0时，才需要考虑收缩的事情
            while (cnt == 0) {
                // 更新数据
                if (result.isEmpty() || right - left + 1 < result.length()) {
                    result = s.substring(left, right + 1);
                }
                // 收缩窗口
                char lc = sc[left];
                if (helper.containsKey(lc)) {
                    int beforeShrink = helper.get(lc);
                    helper.put(lc, beforeShrink + 1);
                    if (beforeShrink == 0) {
                        cnt++;
                    }
                }
                left++;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));

    }
}
