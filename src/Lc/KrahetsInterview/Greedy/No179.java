package Lc.KrahetsInterview.Greedy;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/largest-number/description/">最大数</a>
 **/
public class No179 {

    public String largestNumber(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int item : nums) {
            stringBuilder.append(item);
        }
        String res = stringBuilder.toString();
        int firstNoZero = -1;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') {
                firstNoZero = i;
                break;
            }
        }
        if (firstNoZero == -1) {
            return "0";
        } else {
            return res.substring(firstNoZero);
        }
    }

    public void qsort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && compareStr(pivot, nums[j])) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
                i++;
            }
            while (i < j && compareStr(nums[i], pivot)) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
                j--;
            }
        }
        qsort(nums, start, i - 1);
        qsort(nums, i + 1, end);
    }

    public boolean compareStr(int a, int b) {
        String x = a + "" + b;
        String y = b + "" + a;
        return x.compareTo(y) > 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{1000000000, 1000000000};
        System.out.println(largestNumber(nums));
        nums = new int[]{0, 0};
        System.out.println(largestNumber(nums));
        nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    @Test(description = "")
    public void test123() throws Exception {
        String x = "123";
        String y = "342";

        System.out.println(x.compareTo(y));


    }


}

