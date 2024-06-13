package lc75;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75">移动0</a>
 */
public class No283_moveZeroes {
    public void moveZeroesAns(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int j = k; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        // 存位置
        int pos = nums.length - 1;
        // 存0
        int zero = nums.length - 1;
        // 存最右边非0的数
        int start = nums.length - 1;
        while (pos > 0) {
            pos = start;
            // 先找到最右侧的0
            while (zero >= 0 && nums[zero] != 0) {
                zero--;
            }
            // 如果已经没有0了，则直接break
            if (zero < 0) {
                break;
            }
            // 一边移动pos，一边对调，直到pos和zero相等，再开启下一轮
            while (pos >= 0 && pos != zero) {
                swap(nums, pos, zero);
                pos--;
            }
            zero -= 1;
            start -= 1;
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{0, 1, 0, 3, 12}},
                {new int[]{0, 0, 0, 0, 12}},
                {new int[]{0, 1, 0, 0, 0}},
                {new int[]{0, 0, 0, 0, 0}},
                {new int[]{1, 1, 1, 1, 1}},

        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] nums) throws Exception {
        moveZeroesAns(nums);
        System.out.println(StringUtils.join(Arrays.stream(nums).mapToObj(String::valueOf).toArray(), ","));

    }
}
