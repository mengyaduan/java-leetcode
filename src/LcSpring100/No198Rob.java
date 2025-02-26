package LcSpring100;

public class No198Rob {

    public int rob(int[] nums) {
        int[][] table = new int[nums.length][2];
        table[0][0] = 0;
        table[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            table[i][0] = Math.max(table[i - 1][1], table[i - 1][0]);
            table[i][1] = table[i - 1][0] + nums[i];
        }
        return Math.max(table[nums.length - 1][0], table[nums.length - 1][1]);
    }
}
