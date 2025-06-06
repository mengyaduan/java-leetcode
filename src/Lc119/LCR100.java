package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR100 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        List<Integer> storage = triangle.get(0);
        int i = 1;
        while (i < triangle.size()) {
            List<Integer> storageNew = calculate(triangle, i, storage);
            storage = storageNew;
            i++;
        }
        for (int j = 0; j < storage.size(); j++) {
            result = Math.min(result, storage.get(j));
        }
        return result;
    }

    private List<Integer> calculate(List<List<Integer>> triangle, int cur, List<Integer> storage) {
        List<Integer> res = new ArrayList<>();
        List<Integer> curLine = triangle.get(cur);
        int n = curLine.size();
        res.add(curLine.get(0) + storage.get(0));
        //   2,3,4
        // 3,4, 5, 6
        for (int k = 0; k < storage.size() - 1; k++) {
            int item = Math.min(storage.get(k), storage.get(k + 1)) + curLine.get(k + 1);
            res.add(item);
        }
        res.add(curLine.get(n - 1) + storage.get(n - 2));
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(minimumTotal(list));

    }

}
