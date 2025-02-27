package LcSpring100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No118Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> lastLine = new ArrayList<>(Collections.singletonList(1));
        result.add(lastLine);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> line = createNextLine(result.get(i - 2));
            result.add(line);
        }
        return result;
    }

    private ArrayList<Integer> createNextLine(List<Integer> lastLine) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < lastLine.size() - 1; i++) {
            result.add(lastLine.get(i) + lastLine.get(i + 1));
        }
        result.add(1);
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {

        System.out.println(generate(4));
    }


}
