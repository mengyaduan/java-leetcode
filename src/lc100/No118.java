package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No118 {
    List<List<Integer>> result;

    public List<List<Integer>> generate(int numRows) {
        result = new ArrayList<>();
        List<Integer> lastLine = new ArrayList<>();
        int i = 0;
        while (i < numRows) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            if (!lastLine.isEmpty()) {
                // 存在前一行，追加
                for (int j = 1; j < lastLine.size(); j++) {
                    line.add(lastLine.get(j - 1) + lastLine.get(j));
                }
                line.add(lastLine.get(lastLine.size() - 1));
            }
            result.add(line);
            lastLine = line;
            i++;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(generate(4));


    }
}
