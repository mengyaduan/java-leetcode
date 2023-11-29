package Lc.backtrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class getMaxLteNum {
    //给定一个数N，比如315，和一个数组[1,2,3] ,找出一个由数组组成的最大数，但是这个数要小于N。
    // 没有前提，假定N 的位数和数组长度一致
    // 不想写二分法了 默认数组从高到底排序，直接遍历好了


    int maxResult = Integer.MIN_VALUE;

    public int getMaxLtN(String n, int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        backtrackBin(path, n, nums);
        return maxResult;

    }

    int nIndex = 0;
    boolean needProper = true;

    private void backtrackBin(ArrayList<Integer> path, String n, int[] nums) {
        // 中止条件
        if (!path.isEmpty() && path.size() < n.length()) {
            // 记录过程中的数据，如果存在111，[2]的情况，需要返回22
            int nowPath = Integer.parseInt(StringUtils.join(path, ""));
            if (nowPath >= maxResult) {
                maxResult = nowPath;
            }
        }
        if (path.size() == n.length()) {
            int thisRound = Integer.parseInt(StringUtils.join(path, ""));
            if (thisRound >= Integer.parseInt(n)) {
                return;
            }
            if (thisRound >= maxResult) {
                maxResult = thisRound;
            }
            return;
        }
        int proper = nums.length - 1;
        if (needProper) {
            int target = Integer.parseInt(n.substring(nIndex, nIndex + 1));
            proper = findProper2(nums, target);
            if (proper == -1) {
                // 如果没有，就从最大的试
                proper = nums.length - 1;
                needProper = false;
            }
        }
        for (int i = proper; i >= 0; i--) {
            // i 加入到备选
            path.add(nums[i]);
            nIndex++;
            // backtrack
            backtrackBin(path, n, nums);
            // i 拿出备选
            int len = path.size();
            nIndex--;
            path.remove(len - 1);
        }
    }

    /**
     * 升序数组中，找到小于等于target的最大值的坐标
     * <p>
     * 左闭右开
     */
    private int findProper(int[] nums, int target, int left, int right) {
        if (left >= right) {
            if (right - 1 < 0) {
                return -1;
            } else {
                return right - 1;
            }
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target && mid < nums.length - 1 && nums[mid + 1] > target) {
            return mid;
        }
        if (nums[mid] > target) {
            return findProper(nums, target, left, mid);
        }
        if (nums[mid] < target) {
            return findProper(nums, target, mid + 1, right);
        }
        return -2;
    }


    private int findProper2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    @DataProvider(name = "newOne")
    public Object[][] newOne() {
        return new Object[][]{
                //
                {new int[]{1, 2}, 22, 21},
                {new int[]{1}, 22, 11},
                {new int[]{2}, 2311, 2222},
                {new int[]{2, 1, 9}, 2135, 2129},
                {new int[]{2}, 111, 22},
                {new int[]{1}, 2, 1},
                {new int[]{2}, 2, -1},
                {new int[]{1, 0, 2}, 1013, 1012},
        };
    }

    @Test(description = "", dataProvider = "newOne")
    public void testGetMax(int[] nums, int target, int result) throws Exception {
        String n = String.valueOf(target);
        maxResult = -1;
        int x = getMaxLtN(n, nums);
        Assert.assertEquals(x, result);
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        int[] nums = new int[]{2, 3, 5, 7};
        return new Object[][]{
                //
                {new int[]{2, 3, 5, 7}, 1, -1},
                {new int[]{2, 3, 5, 7}, 2, 0},
                {new int[]{2, 3, 5, 7}, 3, 1},
                {new int[]{2, 3, 5, 7}, 4, 1},
                {new int[]{2, 3, 5, 7}, 5, 2},
                {new int[]{2, 3, 5, 7}, 6, 2},
                {new int[]{2, 3, 5, 7}, 7, 3},
                {new int[]{2, 3, 5, 7}, 8, 3},
                {new int[]{2, 3, 5, 7}, 9, 3},
                {new int[]{3}, 3, 0},
                {new int[]{3}, 1, -1},
                {new int[]{3}, 4, 0},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void testBin(int[] nums, int target, int res) throws Exception {
        int x = findProper(nums, target, 0, nums.length);
        Assert.assertEquals(x, res);

        int y = findProper2(nums, target);
        Assert.assertEquals(y, res);
    }

}
