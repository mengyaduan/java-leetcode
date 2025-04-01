package Lc119;

import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class LCR038 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        result[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                result[i] = 1;
                continue;
            }
            if (temperatures[i] == temperatures[i + 1]) {
                result[i] = result[i + 1] == 0 ? 0 : (result[i + 1] + 1);
                continue;
            }
//            if (temperatures[i] > temperatures[i + 1] && temperatures[i + 1] == 0) {
//                result[i] = 0;
//                continue;
//            }
            // 30,90,50,40,70
            // 1,0,2,1,0
            int days = 1;
            int target = i + 1;
            boolean biggest = false;
            while (target < n && temperatures[i] >= temperatures[target]) {
                if (result[target] == 0) {
                    // 一旦有断点
                    biggest = true;
                    result[i] = 0;
                    break;
                }
                days += result[target];
                target += result[target];
            }
            if (!biggest && target < n) {
                result[i] = days;
            }
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
//        [1,1,4,2,1,1,0,0]
        printIntArray(dailyTemperatures(new int[]{34, 80, 80, 34, 34, 80, 80, 80, 80, 34}));
//        printIntArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}

