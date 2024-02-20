package Lc.doublepointers;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @see <a href="https://leetcode.com/problems/4sum/description/">四数之和</a>
 **/
public class No18_4Sum {

    List<List<Integer>> result;
    List<List<Long>> resultOfThree;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Long targetLong = Long.valueOf(target);
        Arrays.sort(nums);
        Long[] numsLong = Arrays.stream(nums).mapToObj(Long::valueOf).toArray(Long[]::new);

        for (int i = 0; i < numsLong.length - 3; i++) {
            if (i > 0 && Objects.equals(numsLong[i], numsLong[i - 1])) {
                continue;
            }
            // 固定每一位，然后计算后面的三数之和
            List<List<Long>> three = threeSum(numsLong, targetLong - numsLong[i], i + 1);
            if (three.isEmpty()) {
                continue;
            }
            for (List<Long> item : three) {
                ArrayList<Integer> x = new ArrayList<>();
                x.add(nums[i]);
                for (Long y : item) {
                    int m = (int) y.longValue();
                    x.add(m);
                }
                result.add(x);
            }
        }
        return result;
    }

    public List<List<Long>> threeSum(Long[] nums, long targetThree, int threeStart) {
        resultOfThree = new ArrayList<>();
        for (int k = threeStart; k < nums.length - 2; k++) {
            if (k > threeStart && Objects.equals(nums[k], nums[k - 1])) {
                continue;
            }
            calculate(nums, targetThree, k, k + 1, nums.length - 1);
        }
        return resultOfThree;
    }

    public void calculate(Long[] nums, long targetThree, int head, int i, int j) {
        long first = nums[head];
        long need = targetThree - first;
        while (i < j) {
            long sumNow = nums[i] + nums[j];
            if (sumNow < need) {
                while (i < j && Objects.equals(nums[i], nums[++i])) ;
            } else if (sumNow > need) {
                while (i < j && Objects.equals(nums[j], nums[--j])) ;
            } else {
                resultOfThree.add(new ArrayList<>(Arrays.asList(nums[head], nums[i], nums[j])));
                while (i < j && Objects.equals(nums[i], nums[++i])) ;
                while (i < j && Objects.equals(nums[j], nums[--j])) ;
            }
        }
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {"4", new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296},
                {"3", new int[]{-2, -1, -1, 1, 1, 2, 2}, 0},
                {"2", new int[]{2, 2, 2, 2, 2}, 8},
                {"1", new int[]{1, 0, -1, 0, -2, 2}, 0},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(String desc, int[] nums, int target) throws Exception {
        System.out.println(String.format("第%s组", desc));
        List<List<Integer>> x = fourSum(nums, target);
        x.forEach(item -> {
            System.out.println(StringUtils.join(item, ","));
        });
        System.out.println("=====================");
    }

}

