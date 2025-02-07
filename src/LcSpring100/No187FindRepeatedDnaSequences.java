package LcSpring100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No187FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> helper = new HashMap<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String item = s.substring(i, i + 10);
            int count = helper.getOrDefault(item, 0);
            if (count == 1) {
                result.add(item);
            }
            helper.put(item, count + 1);
        }
        return result;
    }
}
