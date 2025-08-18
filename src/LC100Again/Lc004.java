package LC100Again;


import org.testng.annotations.Test;

public class Lc004 {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 往后找到第一个不等于0的坐标，然后互换
                int cur = i + 1;
                int next = -1;
                while (cur < nums.length && nums[cur] == 0) {
                    if (next == -1) {
                        next = cur;
                    }
                    cur++;
                }
                if (cur >= nums.length) {
                    // 如果没有非0了，直接退出
                    return;
                }
                swap(nums, cur, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] x = new int[]{0, 1, 0, 0, 0, 3, 12};
        moveZeroes(x);
        System.out.println(x);

    }
}
