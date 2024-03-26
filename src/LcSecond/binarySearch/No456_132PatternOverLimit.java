package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/132-pattern/description/">是否存在值排序 132</a>
 **/
public class No456_132PatternOverLimit {

    public boolean find132pattern(int[] nums) {
        int[][] sortedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            // 0 的位置存值，1的位置存idx
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }
        // 按照value排序
        Arrays.sort(sortedNums, (a, b) -> {
            return a[0] - b[0];
        });

        // 目标是找到left，mid，right，满足nums[left] < nums[right] < nums[mid]
        int pos = nums.length - 1;
        // 假设最大的是mid，如果不符合再往前找
        while (pos >= 2) {
            int midValue = sortedNums[pos][0];
            int midIdx = sortedNums[pos][1];
            // 在midIdx右侧，找到小于midValue的最大的那个值，赋给rightValue
            int pivot = pos - 1;
            int rightValue = sortedNums[pivot][0];
            int rightIdx = sortedNums[pivot][1];
            while (rightIdx < midIdx || rightValue == midValue) {
                pivot--;
                if (pivot == 0) {
                    break;
                }
                rightValue = sortedNums[pivot][0];
                rightIdx = sortedNums[pivot][1];
            }
            if (pivot == 0) {
                // 不用继续了
                pos--;
                continue;
            }
            // 在midIdx左侧，找到小于rightValue的那个值，如果能找到，直接返回true；否则继续缩小midValue
            pivot = pivot - 1;
            int leftValue = sortedNums[pivot][0];
            int leftIdx = sortedNums[pivot][1];
            while (leftIdx > midIdx || leftValue == rightValue) {
                pivot--;
                if (pivot < 0) {
                    pos--;
                    break;
                }
                leftValue = sortedNums[pivot][0];
                leftIdx = sortedNums[pivot][1];
            }
            if (pivot >= 0) {
                return true;
            }
        }
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{-2, 1, -1};
        System.out.println(find132pattern(nums));

    }


}
