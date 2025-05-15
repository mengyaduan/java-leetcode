package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static DataStruct.tools.printIntArray;

public class LCR075 {


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr2.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            result.add(new ArrayList<>());
        }
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            helper.put(arr2[i], i);
        }
        for (int item : arr1) {
            result.get(helper.getOrDefault(item, n)).add(item);
        }
        result.get(n).sort(Comparator.comparingInt(a -> a));
        ArrayList<Integer> resArr = new ArrayList<>();
        for (ArrayList<Integer> item : result) {
            for (Integer i : item) {
                resArr.add(i);
            }
        }
        return resArr.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        printIntArray(relativeSortArray(arr1, arr2));

    }
}
