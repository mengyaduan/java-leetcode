package Lc.KrahetsInterview.DynamicProgram;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/ugly-number-ii/description/">丑数 ii</a>
 **/
public class No264 {


    public int nthUglyNumber(int n) {
        int index = n - 1;
        ArrayList<Integer> uglyList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        if (index < uglyList.size()) {
            return uglyList.get(index);
        }
        HashMap<Integer, Boolean> usedAll = new HashMap<>();
        usedAll.put(1, true);

        while (uglyList.size() < n) {
            // 当前基线数字，例如 5
            int base = uglyList.get(uglyList.size() - 1);
            int minChoice = Integer.MAX_VALUE;
            // 遍历，找到最近的一个
            for (int i = 0; i < uglyList.size(); i++) {
                int choice = -1;
                if (usedAll.containsKey(uglyList.get(i))) {
                    // 如果已经都用光了，直接跳过
                    continue;
                } else {
                    int[] choices = new int[]{
                            uglyList.get(i) * 2, uglyList.get(i) * 3, uglyList.get(i) * 5
                    };
                    for (int j = 0; j < 3; j++) {
                        if (choices[j] > base) {
                            choice = choices[j];
                            break;
                        }
                    }
                    if (choice == -1) {
                        // 全都用过了，修改标志位
                        usedAll.put(uglyList.get(i), true);
                        continue;
                    }
                    if (choices[0] > minChoice) {
                        // 后面不可能有了
                        break;
                    }
                }
                minChoice = Math.min(minChoice, choice);
            }
            uglyList.add(minChoice);
        }
        System.out.println(StringUtils.join(uglyList, ","));
        return uglyList.get(n - 1);
    }

    public int nthUglyNumberAnswer(int n) {
        ArrayList<Integer> uglyList = new ArrayList<>(Arrays.asList(1));
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (uglyList.size() < n) {
            int p2Res = uglyList.get(p2) * 2, p3Res = uglyList.get(p3) * 3, p5Res = uglyList.get(p5) * 5;
            int nextOne = Math.min(p2Res, Math.min(p3Res, p5Res));
            p2 += nextOne == p2Res ? 1 : 0;
            p3 += nextOne == p3Res ? 1 : 0;
            p5 += nextOne == p5Res ? 1 : 0;
            uglyList.add(nextOne);
        }
        return uglyList.get(n - 1);
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {3, 3},
                {5, 5},
                {6, 6},
                {10, 12},
                {1548, 1080000000},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        Assert.assertEquals(nthUglyNumberAnswer(n), expected);

    }

}

