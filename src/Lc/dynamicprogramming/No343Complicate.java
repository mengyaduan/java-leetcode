package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/integer-break/?show=1">No343 整数拆分求最大积</a>
 **/
public class No343Complicate {

    HashMap<Integer, HashSet<HashMap<Integer, Integer>>> memo = new HashMap<>();
    int maxRes;

    public int integerBreak(int n) {
        maxRes = Integer.MIN_VALUE;
        HashMap<Integer, Integer> init = new HashMap<>();
        init.put(1, 2);
        HashSet<HashMap<Integer, Integer>> dp2 = new HashSet<>();
        dp2.add(init);
        memo.put(2, dp2);
        maxRes = 1;

        for (int i = 3; i <= n; i++) {
            memo.put(i, dp(i));
        }
        return maxRes;
    }


    public HashSet<HashMap<Integer, Integer>> dp(int x) {
        maxRes = Integer.MIN_VALUE;
        HashSet<HashMap<Integer, Integer>> resultSet = new HashSet<>();
        // 上一轮存储的结果
        HashSet<HashMap<Integer, Integer>> lastRound = memo.get(x - 1);
        for (HashMap<Integer, Integer> group : lastRound) {
            expendArray(group, resultSet);
        }
        return resultSet;
    }

    public void expendArray(HashMap<Integer, Integer> group,
                            HashSet<HashMap<Integer, Integer>> resultSet) {
        // 两种扩展方式：位数+1 or 每一位的值+1

        // 长度+1, 即 (1,1) → (1,1,1)
        HashMap<Integer, Integer> itemCountAddOne = new HashMap<>(group);
        itemCountAddOne.putIfAbsent(1, 0);
        itemCountAddOne.computeIfPresent(1, (k, v) -> v + 1);

        boolean isOk = resultSet.add(itemCountAddOne);
        if (isOk) {
            int temp = 1;
            for (Map.Entry entry : itemCountAddOne.entrySet()) {
                BigDecimal k = new BigDecimal((int) entry.getKey());
                temp *= k.pow((int) entry.getValue()).intValue();
            }
            if (temp > maxRes) {
                maxRes = temp;
            }
        }
        // 每一位+1 例如：从（1，2） 右 （2，2）、（1，3）
        for (Map.Entry<Integer, Integer> item : group.entrySet()) {
            HashMap<Integer, Integer> tempMap = new HashMap<>(group);
            int key = item.getKey();
            if (tempMap.containsKey(key)) {
                int value = tempMap.get(key);
                if (value - 1 > 0) {
                    tempMap.put(key, value - 1);
                } else {
                    tempMap.remove(key);
                }
                tempMap.putIfAbsent(key + 1, 0);
                tempMap.computeIfPresent(key + 1, (k, v) -> v + 1);
            }
            isOk = resultSet.add(tempMap);
            if (isOk) {
                int temp = 1;
                for (Map.Entry entry : tempMap.entrySet()) {
                    BigDecimal k = new BigDecimal((int) entry.getKey());
                    temp *= k.pow((int) entry.getValue()).intValue();
                }
                if (temp > maxRes) {
                    maxRes = temp;
                }
            }
        }
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {2, 1},
                {3, 2},
                {4, 4},
                {5, 6},
                {10, 36},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        int res = integerBreak(n);
        Assert.assertEquals(res, expected);
    }


    @Test(description = "")
    public void testdlaksfjalskj() throws Exception {
        HashMap<Integer, Integer> group1 = new HashMap<>();
        group1.put(1, 3);
        HashMap<Integer, Integer> group2 = new HashMap<>();
        group2.put(1, 1);
        group2.put(2, 1);
        HashSet<HashMap<Integer, Integer>> resultSet = new HashSet<>();
        expendArray(group2, resultSet);
        System.out.println(resultSet);
        System.out.println();


    }
}
