package lc150;

/**
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = nums[i] * left[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l = i - 1 >= 0 ? left[i - 1] : 1;
            int r = i + 1 < n ? right[i + 1] : 1;
            res[i] = l * r;
        }
        return res;
    }

}
