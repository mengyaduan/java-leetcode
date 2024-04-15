package LcSecond;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/?envType=daily-question&envId=2024-04-12">接雨水</a>
 **/
public class No42_TrappingRain {

    public int trap(int[] height) {
        // 找到最高值，判断数量，如果等于一个，拆分以后计算；如果有多个，直接结算中间的结果+左右的递归
        int maxV = Integer.MIN_VALUE;
        ArrayList<Integer> idxOfMaxV = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxV) {
                maxV = height[i];
                idxOfMaxV = new ArrayList<>();
                idxOfMaxV.add(i);
            } else if (height[i] == maxV) {
                idxOfMaxV.add(i);
            }
        }
        int res = 0;
        if (idxOfMaxV.size() == 1) {
            res += fromZeroToHigh(height, idxOfMaxV.get(0));
            res += fromHighToLast(height, idxOfMaxV.get(idxOfMaxV.size() - 1));
        } else {
            res += trapWaterCalc(height, idxOfMaxV.get(0), idxOfMaxV.get(idxOfMaxV.size() - 1));
            res += fromZeroToHigh(height, idxOfMaxV.get(0));
            res += fromHighToLast(height, idxOfMaxV.get(idxOfMaxV.size() - 1));
        }
        return res;
    }

    private int fromHighToLast(int[] height, int highest) {
        if (highest >= height.length - 2) {
            return 0;
        }
        int count = 0;
        // 从end往前找, 找小于heighest的最大值，越靠近两边越好
        int secondMax = Integer.MIN_VALUE;
        int secondMaxIdx = -1;
        for (int i = height.length - 1; i > highest; i--) {
            if (height[i] > secondMax) {
                secondMax = height[i];
                secondMaxIdx = i;
            }
        }
        count += trapWaterCalc(height, highest, secondMaxIdx);
        count += fromHighToLast(height, secondMaxIdx);
//        System.out.println("从" + height[highest] + "到尾部的结果=" + count);
        return count;
    }

    /**
     * 右边界最高的时候，计算下左边的水量
     */
    private int fromZeroToHigh(int[] height, int highest) {
        if (highest <= 1) {
            return 0;
        }
        int count = 0;
        // 从start找小于heighest的最大值，越靠近两边越好
        int secondMax = Integer.MIN_VALUE;
        int secondMaxIdx = -1;
        for (int i = 0; i < highest; i++) {
            if (height[i] > secondMax) {
                secondMax = height[i];
                secondMaxIdx = i;
            }
        }
        count += trapWaterCalc(height, secondMaxIdx, highest);
        count += fromZeroToHigh(height, secondMaxIdx);
//        System.out.println("从头部到" + height[highest] + "的结果=" + count);
        return count;
    }

    /**
     * 计算两个顶点之间的水量
     */
    private int trapWaterCalc(int[] height, Integer leftIdx, Integer rightIdx) {
        int top = Math.min(height[leftIdx], height[rightIdx]);
        int count = 0;
        for (int i = leftIdx + 1; i < rightIdx; i++) {
            count += top - height[i];
        }
        return count;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = new int[]{0, 1, 0, 3, 1, 2, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
        height = new int[]{5, 2, 0, 3, 2, 4};
        System.out.println(trap(height));


    }
}
