package Lc.backtrack;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No47 {

    List<List<Integer>> result;
    int[] usedNum;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        usedNum = new int[nums.length];
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (usedNum[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            usedNum[i] = 1;
            backtrack(nums, path);
            usedNum[i] = 0;
            path.remove(path.size() - 1);
            // 需要挪到所有相等的数的最后一个
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));

    }

}
