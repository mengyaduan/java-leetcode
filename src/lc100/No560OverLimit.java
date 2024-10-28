package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class No560OverLimit {


    public int subarraySum(int[] nums, int k) {
        ArrayList<Integer> last = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                result += 1;
            }
            current.add(nums[i]);
            for (int item : last) {
                int tmp = nums[i] + item;
                if (tmp == k) {
                    result++;
                }
                current.add(tmp);
            }
            last = current;
            current = new ArrayList<>();
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));

    }
}