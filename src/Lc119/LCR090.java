package Lc119;

public class LCR090 {
    int[][] table;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        table = new int[n][2];
        int a = dp(nums, 0, n - 1);
        int b = dp(nums, 1, n);
        return Math.max(a, b);
    }

    public int dp(int[] nums, int start, int end) {
        table[start][0] = 0;
        table[start][1] = nums[start];
        for (int i = start + 1; i < end; i++) {
            table[i][0] = Math.max(table[i - 1][0], table[i - 1][1]);
            table[i][1] = Math.max(table[i - 1][0] + nums[i], table[i - 1][1]);
        }
        return Math.max(table[end - 1][0], table[end - 1][1]);
    }

}
