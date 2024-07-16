package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No167TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                break;
            }
        }
        return new int[]{i + 1, j + 1};
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] x = twoSum(new int[]{-1, 0}, -1);
        System.out.println(x[0] + "," + x[1]);
    }
}
