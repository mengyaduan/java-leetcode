package LC100Again;


import org.testng.annotations.Test;

public class Lc088 {

    public int maxProduct(int[] nums) {
        // 题目限制最少一个元素
        int result = nums[0];
        int lastPositive = result;
        int lastNegative = result;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                lastPositive = Math.max(lastPositive * nums[i], nums[i]);
                lastNegative = lastNegative * nums[i];
            } else if (nums[i] < 0) {
                int newPositive = lastNegative * nums[i];
                lastNegative = Math.min(lastPositive * nums[i], nums[i]);
                lastPositive = newPositive;
            } else {
                lastPositive = 0;
                lastNegative = 0;
            }
            result = Math.max(result, lastPositive);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
        System.out.println(maxProduct(new int[]{-2, 3, 4}));
        System.out.println(maxProduct(new int[]{2, -3, 4}));
        System.out.println(maxProduct(new int[]{2, 3, 0, 4}));

    }


}
