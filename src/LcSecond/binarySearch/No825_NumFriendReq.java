package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/friends-of-appropriate-ages/description/">好友数量</a>
 */
public class No825_NumFriendReq {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            int[] bound = lowUpBound(ages[i]);
            if (bound[0] >= bound[1]) {
                continue;
            }
            int left = findLeft(ages, bound[0]);
            int right = findRight(ages, bound[1]);
            int total = right - left + 1;
            if (left <= i && i <= right) {
                total -= 1;
            }
            res += total;
        }
        return res;
    }

    /**
     * 找到小于等于target的最大的坐标
     */
    private int findRight(int[] ages, int target) {
        int l = 0;
        int r = ages.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ages[mid] <= target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    /**
     * 找到大于target的最小的坐标
     */
    private int findLeft(int[] ages, int target) {
        int l = 0;
        int r = ages.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ages[mid] > target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    /**
     * 目标范围： lowBound < y <= upBound
     * 找x能发送好友请求的数值范围，左开右闭
     */
    public int[] lowUpBound(int x) {
        int lowBound = x / 2 + 7;
        int upBound1 = x;
        int upBound2 = Integer.MAX_VALUE;
        if (x < 100) {
            upBound2 = 100;
        }
        int upBound = Math.min(upBound1, upBound2);
        return new int[]{lowBound, upBound};
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(numFriendRequests(new int[]{101, 98, 80, 20, 1, 97, 3, 77, 114, 109}));
//        System.out.println(numFriendRequests(new int[]{16, 16}));
//        System.out.println(numFriendRequests(new int[]{16, 17, 18}));
//        System.out.println(numFriendRequests(new int[]{20, 30, 100, 110, 120}));

    }

    @Test(description = "")
    public void test123() throws Exception {
        int[] ages = new int[]{
                16, 17, 18, 19, 20
        };
        int l = findLeft(ages, 17);
        int r = findRight(ages, 19);
        System.out.println(l);
        System.out.println(r);

    }
}
