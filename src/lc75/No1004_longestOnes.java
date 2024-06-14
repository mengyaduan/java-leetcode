package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75">最大连续1的个数iii</a>
 */
public class No1004_longestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = nums.length ;
        // 初始化窗口
        int chance = k;
        // right指向的永远是下一个要被替换的0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (chance > 0) {
                    chance--;
                } else {
                    right = i;
                    break;
                }
            }
        }
        int res = right - left;
        // 右侧达到边界时截止
        while (right < nums.length) {
            //  扩展右边界，在right右侧找到第一个0，或者直接找到最右边
            int tmp = right + 1;
            while (tmp < nums.length && nums[tmp] == 1) {
                tmp++;
            }
            right = tmp;
            // 收缩左边界，在left右侧找到第一个0，指向next
            while (nums[left] != 0) {
                left++;
            }
            left++;
            // 比大小
            res = Math.max(res, right - left);
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestOnes(new int[]{0, 0, 0, 1}, 4));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));

    }
}
