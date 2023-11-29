package Lc.backtrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class getMaxLtNum {
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
        if (!path.isEmpty()) {
            int thisRound = Integer.parseInt(StringUtils.join(path, ""));
            if (thisRound >= Integer.parseInt(n)) {
                return;
            }
            if (thisRound >= maxResult) {
                maxResult = thisRound;
            }
            if (path.size() == n.length()) {
                return;
            }
        }
        int proper = nums.length - 1;
        if (needProper) {
            int target = Integer.parseInt(n.substring(nIndex, nIndex + 1));
            proper = findProper(nums, target);
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

    private int findProper(int[] nums, int target) {
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

}
