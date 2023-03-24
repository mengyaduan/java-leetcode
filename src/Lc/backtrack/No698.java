package Lc.backtrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/partition-to-k-equal-sum-subsets/">No698 划分为k个相等的子集</a>
 **/
public class No698 {


    HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }

        int used = 0; // 使用位图技巧
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    public boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            if ((used >> i & 1) == 1) {
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            used |= 1 << i;
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            used ^= 1 << i;
            bucket -= nums[i];
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
        memo.clear();
        Assert.assertEquals(canPartitionKSubsets(nums, k), resultExpectd);
    }

}
