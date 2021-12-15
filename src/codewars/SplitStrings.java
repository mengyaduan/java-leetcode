package codewars;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author yameng.dym
 * @see <a href="https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/java"></a>
 **/
public class SplitStrings {
    public String[] solution(String s) {
        String s1 = s.length() % 2 == 0 ? s : s + "_";
        String[] res = new String[s1.length() / 2];
        for (int i = 0; i < s1.length(); i += 2) {
            res[i / 2] = s1.substring(i, i + 2);
        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"abcdef", new String[]{"ab", "cd", "ef"}},
                {"abcde", new String[]{"ab", "cd", "e_"}},
                {"a", new String[]{"a_"}},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String[] expected) {
        String[] res = solution(s);
        for (String x : res) {
            System.out.print(x + "\t");
        }
        System.out.println();
//        Assert.assertEquals(res, expected);
    }

}
