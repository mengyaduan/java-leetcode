package LC100Again;


import org.testng.annotations.Test;

public class Lc100 {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int value = nums[i];
            // value应该在的位置是value-1
            int idx = value - 1;
            if (i == idx) {
                // 如果value就在它自己的位置，则前进处理下一个
                i++;
                continue;
            }
            if (nums[idx] == value) {
                // 如果已经重复了，直接返回就行了
                return value;
            }
            // 如果不重复，将value放到它该去的地方
            nums[i] = nums[idx];
            nums[idx] = value;
        }
        // 实际走不到这里
        return -1;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));

    }


}
