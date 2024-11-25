package lc100;

import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class No739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        // 最后一个一定是0
        result[result.length - 1] = 0;
        int i = result.length - 2, j = result.length - 1;
        while (i >= 0) {
            if (j >= result.length) {
                result[i] = 0;
                j = i;
                i--;
            } else if (temperatures[i] < temperatures[j]) {
                result[i] = j - i;
                j = i;
                i--;
            } else {
                j = result[j] == 0 ? result.length : j + result[j];
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        printIntArray(dailyTemperatures(temperatures));
    }

    @Test(description = "")
    public void test1() throws Exception {
        int[] temperatures = new int[]{30, 40, 50, 60};
        printIntArray(dailyTemperatures(temperatures));
    }

    @Test(description = "")
    public void test2() throws Exception {
        int[] temperatures = new int[]{30, 40, 80, 60};
        printIntArray(dailyTemperatures(temperatures));
    }

}
