package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/description/"></a>
 **/
public class No76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> dictAns = new HashMap<>();
        for (Character item : t.toCharArray()) {
            dictAns.put(item, dictAns.getOrDefault(item, 0) + 1);
        }
        HashMap<Character, Integer> dict = new HashMap<>();
        int left = 0, right = 0;
        String maxRes = "";

        while (true) {
            // 扩右边界
            char cur = s.charAt(right);
            if (dictAns.containsKey(cur)) {
                dict.put(cur, dict.getOrDefault(cur, 0) + 1);
            }
            right++;
            if (!everyCharOfTisInSub(dictAns, dict)) {
                // 没有满足条件，就继续扩
                if (right == s.length()) {
                    break;
                }
                continue;
            }
            // 满足条件后，开始缩左边界，如果right已经到达s.lenght()，则break
            while (left < right) {
                char curLeft = s.charAt(left);
                if (dict.containsKey(curLeft) && dict.get(curLeft) > dictAns.get(curLeft)) {
                    dict.put(curLeft, dict.get(curLeft) - 1);
                    left++;
                } else if (!dict.containsKey(curLeft)) {
                    left++;
                } else {
                    break;
                }
            }
            if (maxRes == "") {
                maxRes = s.substring(left, right);
            } else {
                maxRes = s.substring(left, right).length() < maxRes.length() ? s.substring(left, right) : maxRes;
            }
            // 更新后，左侧收缩，前进找下一个
            if (dict.containsKey(s.charAt(left))) {
                dict.put(s.charAt(left), dict.get(s.charAt(left)) - 1);
            }
            left++;
            if (right == s.length()) {
                break;
            }
        }
        return maxRes;
    }

    private boolean everyCharOfTisInSub(HashMap<Character, Integer> ans, HashMap<Character, Integer> now) {
        for (Map.Entry<Character, Integer> entry : ans.entrySet()) {
            if (!now.containsKey(entry.getKey()) || now.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
//                {"ADOBECODEBANC", "ABC", "BANC"},
//                {"ADOBECODEBANC", "DB", "DOB"},
//                {"ADOBECODEBANC", "AB", "BA"},
//                {"A", "A", "A"},
                {"", "A", ""},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, String expected) {
        String res = minWindow(s, t);
        Assert.assertEquals(res, expected);
    }

}

