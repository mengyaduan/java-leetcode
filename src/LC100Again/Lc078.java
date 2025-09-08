package LC100Again;


import org.testng.annotations.Test;

public class Lc078 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] maxDis = new int[n];
        maxDis[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                // 当前坐标能前进的最远距离默认就是
                maxDis[i] = Math.max(maxDis[i], i + j);
                // 如果maxDis[i+j]更远的话，可以替换
                maxDis[i] = Math.max(maxDis[i], maxDis[i + j]);
            }
        }
        return maxDis[0] >= n - 1;
    }


    public boolean canJumpAns(int[] nums) {
        int maxDis = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxDis < i) {
                return false;
            }
            maxDis = Math.max(maxDis, i + nums[i]);
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJumpAns(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJumpAns(new int[]{3, 2, 1, 0, 4}));

    }

}
