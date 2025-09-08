package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc080 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> lastOccurIdx = new HashMap<>();
        char[] sc = s.toCharArray();
        // 标记每个字符最后出现的位置
        for (int i = 0; i < sc.length; i++) {
            lastOccurIdx.put(sc[i], i);
        }
        int pivot = -1;
        int last = -1;
        for (int i = 0; i < sc.length; i++) {
            if (lastOccurIdx.get(sc[i]) > pivot) {
                pivot = lastOccurIdx.get(sc[i]);
            }
            if (i == pivot) {
                result.add(pivot - last);
                last = pivot;
            }
        }
        return result;
    }

    @Test(description = "")
    public void testsou() throws Exception {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }

}
