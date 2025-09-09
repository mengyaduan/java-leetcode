package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc082 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastRow = new ArrayList<>();
        lastRow.add(1);
        result.add(lastRow);
        while (result.size() < numRows) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for (int i = 1; i < lastRow.size(); i++) {
                line.add(lastRow.get(i - 1) + lastRow.get(i));
            }
            line.add(1);
            result.add(line);
            lastRow = line;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(generate(4));
    }


}
