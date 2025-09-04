package LC100Again;


import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class Lc072 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        result[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                result[i] = 1;
            } else if (temperatures[i] == temperatures[i + 1]) {
                result[i] = result[i + 1] == 0 ? 0 : (result[i + 1] + 1);
            } else {
                int step = 0;
                int nextIdx = i + 1;
                boolean hasNext = true;
                while (nextIdx < n && temperatures[i] >= temperatures[nextIdx]) {
                    if (result[nextIdx] == 0) {
                        hasNext = false;
                        break;
                    }
                    step += result[nextIdx];
                    nextIdx = nextIdx + result[nextIdx];
                }
                if (!hasNext || nextIdx >= n) {
                    result[i] = 0;
                } else {
                    result[i] = step + 1;
                }
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        printIntArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        printIntArray(dailyTemperatures(new int[]{30, 40, 50, 60}));

    }


}
