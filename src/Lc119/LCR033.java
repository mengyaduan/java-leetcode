package Lc119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LCR033 {

    List<List<String>> result;
    HashMap<Integer, List<String>> helper;

    public List<List<String>> groupAnagrams(String[] strs) {
        result = new ArrayList<>();
        helper = new HashMap<>();
        ArrayList<int[]> patterns = new ArrayList();
        for (String s : strs) {
            matchPattern(patterns, s);
        }
        return result;
    }

    private void matchPattern(ArrayList<int[]> patterns, String s) {
        int[] patternNew = new int[26];
        for (char c : s.toCharArray()) {
            patternNew[c - 'a']++;
        }
        for (int i = 0; i < patterns.size(); i++) {
            int[] pattern = patterns.get(i);
            boolean res = true;
            for (int j = 0; j < 26; j++) {
                if (pattern[j] != patternNew[j]) {
                    res = false;
                    break;
                }
            }
            if (res) {
                helper.get(i).add(s);
                return;
            }
        }
        // 如果走到这里，说明是新的模式，则直接new一个，追加到结果，同时更新patterns
        ArrayList<String> ansNew = new ArrayList<>(Arrays.asList(s));
        result.add(ansNew);
        patterns.add(patternNew);
        helper.put(patterns.size() - 1, ansNew);
    }

}
