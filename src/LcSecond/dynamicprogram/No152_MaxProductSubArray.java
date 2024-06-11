package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/maximum-product-subarray/description/">子数组的积</a>
 */
public class No152_MaxProductSubArray {

    public int maxProduct(int[] nums) {
        ArrayList<ArrayList<Integer>> sections = new ArrayList<>();

        int res = Integer.MIN_VALUE;
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res = 0;
                if (!path.isEmpty()) {
                    sections.add(new ArrayList<>(path));
                }
                // 新增分片
                path = new ArrayList<>();
            } else {
                path.add(nums[i]);
            }
        }
        if (!path.isEmpty()) {
            sections.add(path);
        }

        for (ArrayList<Integer> item : sections) {
            res = Math.max(getMax(item), res);
        }
        return res;
    }

    private int getMax(ArrayList<Integer> n) {
        if (n.size() == 1) {
            return n.get(0);
        }
        int countNeg = 0;
        int total = 1;
        int firstPart = 1;
        int lastPart = 1;
        boolean negLeft = false;
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i) < 0) {
                countNeg++;
                if (!negLeft) {
                    negLeft = true;
                    // 计算第一个负数及其之前的所有数的乘积
                    firstPart *= n.get(i);
                }
                // 只要遇到负数，lastPart就变成该负数，从而获取到最后一个负数及其右侧所有数的乘积
                lastPart = 1;
            }
            if (!negLeft) {
                // 计算第一个负数之前的所有数的积
                firstPart *= n.get(i);
            }
            lastPart *= n.get(i);
            total *= n.get(i);
        }
        if (countNeg % 2 == 0) {
            return total;
        }
        //
        int a = total / firstPart;
        int b = total / lastPart;
        return Math.max(a, b);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{0};
        System.out.println(maxProduct(nums));
    }

    @Test(description = "")
    public void test2() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, -5, 1, 2, -3, 4, -3, 1, 2, 3));
        System.out.println(getMax(a));

    }
}
