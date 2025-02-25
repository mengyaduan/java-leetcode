package LcSpring100;

public class No268MissingNumber {

    public int missingNumber(int[] nums) {
        int total = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            total += i;
            sum += nums[i];
        }
        return total + nums.length - sum;
    }
}
