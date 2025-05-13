package Lc119;

import java.util.Random;

public class LCR071 {

    int sum = 0;
    int[] nums;

    public void Solution(int[] w) {
        nums = new int[w.length];
        nums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            nums[i] = w[i] + nums[i - 1];
        }
        sum = nums[w.length - 1];
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(sum);
        int l = 0, r = nums.length - 1;
        // 1,2,3,4,5
        // 1,3,6,10,15
        // 找到第一个大于等于target的数字，返回其idx

        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

}
