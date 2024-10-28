package Lc.dynamicprogramming;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?envType=daily-question&envId=2024-10-25"></a>
 */
public class No3180_maxTotalReward {


    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        HashSet<Integer> helper = new HashSet<>();
        int result = rewardValues[0];
        // init
        helper.add(result);
        helper.add(0);
        ArrayList<Integer> toBeAdded = new ArrayList<>();
        for (int i = 1; i < rewardValues.length; i++) {
            toBeAdded.clear();
            for (Integer item : helper) {
                if (rewardValues[i] > item) {
                    int v = item + rewardValues[i];
                    result = Math.max(v, result);
                    toBeAdded.add(v);
                }
            }
            helper.addAll(toBeAdded);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(maxTotalReward(new int[]{1, 6, 3, 2, 4}));

    }


}
