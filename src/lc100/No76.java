package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class No76 {

    public String minWindow(String s, String t) {
        char[] sc = s.toCharArray();
        HashMap<Character, Integer> pattern = new HashMap<>();
        int totalCharNum = t.length();
        for (char c : t.toCharArray()) {
            int count = pattern.getOrDefault(c, 0);
            pattern.put(c, count + 1);
        }
        String result = "";
        int left = 0, right = 0;
        int matchCount = 0;
        HashMap<Character, Integer> helper = new HashMap<>();
        while (right < sc.length) {
            // 扩展右边界，直到包含所有字母
            while (right < sc.length && matchCount < totalCharNum) {
                char rightItem = sc[right];
                if (pattern.containsKey(rightItem)) {
                    // 模板里面有，需要更新数据
                    int count = helper.getOrDefault(rightItem, 0);
                    if (count < pattern.get(rightItem)) {
                        // 且当前累计值小于模板时，加入的才是有效的，否则只记录当前内部数据就可以了
                        matchCount++;
                    }
                    helper.put(rightItem, count + 1);
                }
                right++;
            }
            // 缩小左边界到正合适的位置
            int i = left;
            while (i < right) {
                char leftItem = sc[i];
                if (pattern.containsKey(leftItem)) {
                    int count = helper.get(leftItem);
                    int countInPattern = pattern.get(leftItem);
                    if (count == countInPattern) {
                        left = i;
                        break;
                    }
                    helper.put(leftItem, count - 1);
                }
                i++;
            }
            if (matchCount == totalCharNum) {
                // 已经满足模板，如果满足，比较长度，更新结果，缩小左边界
                if (result.length() == 0 || (right - left) < result.length()) {
                    result = s.substring(left, right);
                }
                // 缩小左边界，只缩一步
                char leftItem = sc[i];
                int count = helper.get(leftItem);
                helper.put(leftItem, count - 1);
                matchCount--;
                left += 1;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(minWindow("ADOBECODEBANC", "ABC"), "BANC");
        Assert.assertEquals(minWindow("a", "a"), "a");
        Assert.assertEquals(minWindow("a", "aa"), "");
        Assert.assertEquals(minWindow("ab", "b"), "b");
        Assert.assertEquals(minWindow("aab", "aab"), "aab");


    }
}
