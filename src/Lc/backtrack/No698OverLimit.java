package Lc.backtrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/partition-to-k-equal-sum-subsets/">No698 划分为k个相等的子集</a>
 **/
public class No698OverLimit {

    HashSet<Integer> idxUsed = new HashSet<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        return backtrack(k, 0, nums, 0, target);
    }

    public boolean backtrack(int k, int bucket, int[] nums, int start, int target) {
        if (k == 0) {
            return true;
        }

        if (bucket == target) {
            boolean res = backtrack(k - 1, 0, nums, 0, target);
            return res;
        }
        for (int i = start; i < nums.length; i++) {
            if (idxUsed.contains(i)) {
                continue;
            }
            if (bucket + nums[i] > target) {
                continue;
            } else {
                idxUsed.add(i);
                if (backtrack(k, bucket + nums[i], nums, i + 1, target)) {
                    return true;
                }
                idxUsed.remove(i);
            }
        }
        return false;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{4, 3, 2, 3, 5, 2, 1}, 4, true},
                {new int[]{4, 3, 2, 3, 5, 2, 1}, 5, false},
                {new int[]{1, 2, 3, 4}, 3, false},
                {new int[]{1, 2, 2, 1}, 3, true},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int k, boolean resultExpectd) {
        idxUsed.clear();
        Assert.assertEquals(canPartitionKSubsets(nums, k), resultExpectd);
    }

}
