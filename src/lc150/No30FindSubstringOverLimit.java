package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No30FindSubstringOverLimit {

    HashMap<Character, ArrayList<String>> helper;

    public List<Integer> findSubstring(String s, String[] words) {
        helper = new HashMap<>();
        int targetLen = 0;
        for (int i = 0; i < words.length; i++) {
            String item = words[i];
            targetLen += item.length();
            helper.putIfAbsent(item.charAt(0), new ArrayList<>());
            helper.get(item.charAt(0)).add(item);
        }
        List<Integer> result = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length - targetLen + 1; i++) {
            if (!helper.containsKey(cs[i])) {
                continue;
            }
            // 往i后数targetLen，看是否全部包含
            HashMap<String, Integer> used = new HashMap<>();
            for (String item : words) {
                used.put(item, used.getOrDefault(item, 0) + 1);
            }
            boolean res = tryToMatch(s.substring(i, i + targetLen), 0, used, new HashSet<>());
            if (res) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 从start开始，往后匹配，如果长度达到targetLen，则true，否则false
     */
    private boolean tryToMatch(String s, int start, HashMap<String, Integer> used, HashSet<Integer> memo) {
        if (start == s.length()) {
            return true;
        }
        if (start > s.length()) {
            return false;
        }
        if (!helper.containsKey(s.charAt(start))) {
            return false;
        }
        if (memo.contains(start)) {
            return false;
        }
        boolean result = false;
        for (String item : helper.get(s.charAt(start))) {
            if (used.get(item) > 0 && s.startsWith(item, start)) {
                // 如果符合条件
                used.put(item, used.get(item) - 1);
                result = tryToMatch(s, start + item.length(), used, memo);
                if (result) {
                    return true;
                }
                used.put(item, used.get(item) + 1);
            }
        }
        memo.add(start);
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        String s = "abcdef";
        String[] words = {"def", "abc"};
        int[] used = new int[words.length];

        helper = new HashMap<>();
        int targetLen = 0;
        for (int i = 0; i < words.length; i++) {
            String item = words[i];
            targetLen += item.length();
            helper.putIfAbsent(item.charAt(0), new ArrayList<>());
            helper.get(item.charAt(0)).add(item);
        }
//        System.out.println(tryToMatch("abcdef", 0, used));

    }

    @Test(description = "")
    public void test2() throws Exception {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        System.out.println(findSubstring(s, words));

    }

}
