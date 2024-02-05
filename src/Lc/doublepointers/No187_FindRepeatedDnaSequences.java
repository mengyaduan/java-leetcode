package Lc.doublepointers;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/repeated-dna-sequences/description/">找到重复的dna序列</a>
 **/
public class No187_FindRepeatedDnaSequences {
    // 滑动窗口，找到所有重复的字符串
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }
        HashMap<String, Integer> dnaMap = new HashMap<>();
        int i = 0, j = 10;
        while (j <= s.length()) {
            String subS = s.substring(i, j);
            dnaMap.put(subS, dnaMap.getOrDefault(subS, 0) + 1);
            i++;
            j++;
        }
        for (Map.Entry<String, Integer> entry : dnaMap.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<String> res = findRepeatedDnaSequences("AAAAAAAAAAA");
        res.forEach(System.out::println);

    }
}

