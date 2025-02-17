package LcSpring100;

import org.testng.annotations.Test;

import java.util.Arrays;

import static DataStruct.tools.printIntArray;

public class No324WiggleSort {

    public void wiggleSortComlex(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int[] memo = Arrays.copyOf(nums, nums.length);
        int idx = 0;
        while (i < j) {
            // 一对对放
            if (memo[i] < memo[j]) {
                nums[idx++] = memo[i];
            } else {
                // 如果不符合，则从前一个符合的逆转
                int cur = idx - 2;
                while (cur >= 0 && (nums[cur] == memo[i] || nums[cur + 1] == memo[i])) {
                    cur -= 2;
                }
                nums[idx] = nums[cur];
                nums[cur] = memo[i];
                idx++;
            }
            nums[idx++] = memo[j];
            i++;
            j--;
        }
        if (i == j) {
            if (nums[idx - 1] == memo[i]) {
                // 向前找一对数字，需要满足两个数都不等于当前值
                int item = memo[i];
                j = idx - 2;
                while (j >= 0 && (nums[j] == item || nums[j + 1] == item)) {
                    j -= 2;
                }
                nums[idx] = nums[j];
                nums[j] = item;
            } else {
                nums[idx] = memo[i];
            }
        }
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] memo = nums.clone();
        int length = memo.length;
        int i = (length - 1) / 2;
        int j = length - 1;
        for (int k = 0; k < memo.length; k++) {
            if (k % 2 == 0) {
                nums[k] = memo[i--];
            } else {
                nums[k] = memo[j--];
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};
        wiggleSort(nums);
        printIntArray(nums);
    }
}
