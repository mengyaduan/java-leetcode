package LcSpring100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No486PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int score1 = 0, score2 = 0;
        return predict(nums, 0, nums.length - 1, score1, score2, true);
    }

    private boolean predict(int[] nums, int start, int end, int score1, int score2, boolean p1First) {
        if (start > end) {
            return score1 >= score2;
        }
        if (p1First) {
            boolean left = predict(nums, start + 1, end, score1 + nums[start], score2, false);
            boolean right = predict(nums, start, end - 1, score1 + nums[end], score2, false);
            return left || right;
        } else {
            boolean left = predict(nums, start + 1, end, score1, score2 + nums[start], true);
            boolean right = predict(nums, start, end - 1, score1, score2 + nums[end], true);
            return left && right;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertFalse(predictTheWinner(new int[]{1, 5, 2}));
        Assert.assertTrue(predictTheWinner(new int[]{1, 5, 233, 7}));

    }


}
