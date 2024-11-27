package lc100;

import bsh.servlet.SimpleTemplate;
import org.testng.annotations.Test;

import javax.activation.FileTypeMap;
import java.util.ArrayList;

public class No45 {

    int result;
    int[] memo;

    public int jump(int[] nums) {
        int result = 0;
        int rightBound = 0;
        int nextRightBound = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 这里只需要遍历到倒数第二个点就好了，最后一个点和0一样，没有必要
            // 一直更新最远的边界
            nextRightBound = Math.max(nextRightBound, i + nums[i]);
            // 当走到头的时候，选择下一条桥
            if (i >= rightBound) {
                rightBound = nextRightBound;
                result++;
            }
        }
        return result;
    }

    public int jumpComplex(int[] nums) {
        result = Integer.MAX_VALUE;
        memo = new int[nums.length];
        result = func(nums, 0);
        return result;
    }

    /**
     * 超复杂
     */
    private int func(int[] nums, int idx) {
        if (idx >= nums.length - 1) {
            return 0;
        }
        if (nums[idx] == 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[idx] != 0) {
            return memo[idx];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            int canJump = func(nums, idx + i);
            int item = canJump == Integer.MAX_VALUE ? canJump : canJump + 1;
            res = Math.min(item, res);
        }
        memo[idx] = res;
        return res;
    }

    /**
     * 超时
     */
    public void backtrack(int[] nums, int idx, ArrayList<Integer> path) {
        if (idx >= nums.length - 1) {
            result = Math.min(result, path.size());
            return;
        }
        if (memo[idx] > 0) {
            return;
        }
        for (int i = 1; i <= nums[idx]; i++) {
            path.add(idx);
            backtrack(nums, idx + i, path);
            path.remove(path.size() - 1);
        }
        memo[idx] = 1;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));

    }
}
