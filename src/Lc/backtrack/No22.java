package Lc.backtrack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/?show=1">No22 括号生成</a>
 **/
public class No22 {


    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return res;

    }

    public void backtrack(String path, int left, int right, int max) {
        if (path.length() == max * 2) {
            res.add(path);
            return;
        }
        if (left < max) {
            backtrack(path + "(", left + 1, right, max);
        }
        if (left > right) {
            backtrack(path + ")", left, right + 1, max);
        }
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {3},
                {1},
                {8}
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n) {
        res.clear();
        List<String> x = generateParenthesis(n);
        System.out.println(x);

//        Assert.assertTrue(res.size() == resultExpected.size());
//        for (String item : resultExpected) {
//            Assert.assertTrue(res.contains(item));
//        }
    }

}
