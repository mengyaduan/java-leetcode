package Lc.KrahetsInterview.Greedy;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/candy/description/"></a>
 **/
public class No135 {

    public int candyAns(int[] ratings) {
        int[] left = new int[ratings.length];
        Arrays.fill(left, 1);
        int[] right = new int[ratings.length];
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < left.length; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    public void printIntArray(int[] nums) {
        String[] x = Arrays.stream(nums).mapToObj(Integer::toString).toArray(String[]::new);
        System.out.println(StringUtils.join(x, ","));
    }

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] memo = new int[ratings.length];
        if (ratings[0] > ratings[1]) {
            memo[0] = 2;
            memo[1] = 1;
        } else if (ratings[0] == ratings[1]) {
            memo[0] = 1;
            memo[1] = 1;
        } else {
            memo[0] = 1;
            memo[1] = 2;
        }
        int left = memo[1];
        for (int i = 2; i < ratings.length; i++) {
            if (ratings[i] == ratings[i - 1]) {
                memo[i] = 1;
                left = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                memo[i] = left + 1;
                left++;
            } else {
                if (left > 1) {
                    memo[i] = 1;
                    left = 1;
                } else {
                    // i-1给了1颗糖果，i需要给的更少
                    memo[i] = 1;
                    left = 1;
                    int updateIndex = i;
                    while (updateIndex > 0 && !satisfy(ratings, memo, updateIndex - 1, updateIndex)) {
                        // 3,4,5,5,3
                        // 1,2,3,1,
                        // 从i往前更新，直到出现分数持平或者分数下跌时停止
                        modify(ratings, memo, updateIndex - 1, updateIndex);
                        updateIndex--;
                    }

                }
            }
        }
        String[] x = Arrays.stream(memo).mapToObj(Integer::toString).toArray(String[]::new);
        System.out.println(StringUtils.join(x, ","));
        return Arrays.stream(memo).sum();
    }

    public void modify(int[] ratings, int[] nums, int left, int right) {
        if (ratings[left] == ratings[right]) {
            return;
        }
        if (ratings[right] < ratings[left] && nums[right] >= nums[left]) {
            nums[left] = nums[right] + 1;
        }
    }

    public boolean satisfy(int[] ratings, int[] nums, int left, int right) {
        if (ratings[left] == ratings[right]) {
            return true;
        }
        if (ratings[left] < ratings[right]) {
            return nums[left] < nums[right];
        }
        return nums[left] > nums[right];
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(candyAns(new int[]{3, 2, 1, 1, 4, 3, 3}), 11);
        Assert.assertEquals(candyAns(new int[]{1, 2, 87, 87, 87, 2, 1}), 13);
        Assert.assertEquals(candyAns(new int[]{3, 4, 5, 5, 3}), 9);
        Assert.assertEquals(candyAns(new int[]{1, 2, 3}), 6);
        Assert.assertEquals(candyAns(new int[]{1, 2, 2}), 4);
        Assert.assertEquals(candyAns(new int[]{2, 2, 2}), 3);
        Assert.assertEquals(candyAns(new int[]{1, 2, 3, 1, 0}), 9);
        Assert.assertEquals(candyAns(new int[]{1, 3, 2, 2, 1}), 7);
    }
}
