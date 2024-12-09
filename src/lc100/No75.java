package lc100;

import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class No75 {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] < nums[j]) {
                // 符合排序，i如果是0则前进，j如果是2则后退
                i += nums[i] == 0 ? 1 : 0;
                j -= nums[j] == 2 ? 1 : 0;
            } else if (nums[i] > nums[j]) {
                // 不符合排序，交换后必符合，按照规则缩小窗口
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                // 如果相等，则需要单边试探，假设从右侧往左边试探，即从j→i
                int k = j - 1;
                for (k = j - 1; k > i; k--) {
                    if (nums[k] != nums[j]) {
                        //找到任何一个不相等的，直接替换重来
                        int temp = nums[k];
                        nums[k] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                if (k == i) {
                    // 没有任何排序异常的
                    j = k;
                }
            }
        }
        printIntArray(nums);
    }

    @Test(description = "")
    public void test() throws Exception {
        sortColors(new int[]{0, 1, 2, 0, 1, 2});

    }
}
