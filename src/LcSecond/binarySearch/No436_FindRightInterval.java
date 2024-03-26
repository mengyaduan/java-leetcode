package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/find-right-interval/description/">找到右区间</a>
 **/
public class No436_FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 1) {
            return new int[]{intervals[0][0] == intervals[0][1] ? 0 : -1};
        }
        // 其实就是把start排序，每次找start最接近的那个，返回坐标就行了
        HashMap<Integer, Integer> helper = new HashMap<>();
        int[] startNums = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startNums[i] = intervals[i][0];
            helper.put(intervals[i][0], i);
        }
        // 把start排序
        Arrays.sort(startNums);
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int endI = intervals[i][1];
            result[i] = helper.getOrDefault(findTarget(startNums, endI), -1);
        }
        return result;
    }

    /**
     * 返回在有序的nums中，大于等于target的数字
     */
    public int findTarget(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = nums[mid];
            if (num == target) {
                return num;
            } else if (num > target) {
                res = num;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] x = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(findTarget(x, 3));
        System.out.println(findTarget(x, 10));
        System.out.println(findTarget(x, 2));
        System.out.println(findTarget(x, 16));
        System.out.println(findTarget(x, 1));

    }

    @Test(description = "")
    public void test123() throws Exception {
        int[][] inter = new int[][]{{3, 4}, {2, 3}, {1, 2}};
        int[] x = findRightInterval(inter);
        System.out.println(x);
    }

    @Test(description = "")
    public void test12() throws Exception {
        int[][] inter = new int[][]{{1, 4}, {2, 3}, {3, 4}};
        int[] x = findRightInterval(inter);
        System.out.println(x);
    }

}
