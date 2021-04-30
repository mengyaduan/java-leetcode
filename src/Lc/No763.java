package Lc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a herf="https://leetcode.com/problems/partition-labels/"></a>
 **/
public class No763 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int len = S.length();
        int leftCursor = 0;
        int rightCursor = len - 1;
        while (leftCursor < len) {
            for (int i = rightCursor; i >= leftCursor; i--) {
                if (S.charAt(i) == S.charAt(leftCursor)) {
                    rightCursor = i;
                    break;
                }
            }
            for (int i = leftCursor + 1; i < rightCursor; i++) {
                for (int j = rightCursor + 1; j < len; j++) {
                    if (S.charAt(i) == S.charAt(j)) {
                        rightCursor = j;
                    }
                }
            }
            result.add(rightCursor - leftCursor + 1);
            leftCursor = rightCursor + 1;
            rightCursor = len - 1;
        }
        return result;
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        Object[][] data = {
                {"ababcbacadefegdehijhklij", new ArrayList<>(Arrays.asList(9, 7, 8))},
                {"a", new ArrayList<>(Arrays.asList(1))},
                {"ab", new ArrayList<>(Arrays.asList(1, 1))},
                {"abcb", new ArrayList<>(Arrays.asList(1, 3))},
                {"aebbedaddc", new ArrayList<>(Arrays.asList(9, 1))},
                {"aebbedaddc", new ArrayList<>(Arrays.asList(9, 2))},
        };
        return data;
    }

    @Test(description = "自测", dataProvider = "data")
    public void test(String s, ArrayList<Integer> res) {
        String x = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        Assert.assertEquals(res, result, "预期输出：" + res + "\n实际输出:" + result);
    }
}
