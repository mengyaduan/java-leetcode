package Lc.doublepointers;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/sort-colors/description/">颜色分类</a>
 **/
public class No75_SortColors {
    // 实际就是排序，但是三个颜色的排序可以用指针遍历一次解决
    public void sortColors(int[] nums) {
        // 定义三个颜色的指针，0，1颜色指向头，2指向尾巴
        int red = 0, white = 0, blue = nums.length - 1;
        while (white <= blue) {
            if (nums[white] == 0) {
                // 如果白指针是红色，那么需要和红指针交换一下。交换过后同时向后++
                // 之所以可行的原因是
                // 开始时白指针红指针指向同一个地方，但是白指针可能会单独前进。红指针只有两种结果，指向0和1。
                // 如果红指针指向0，此时交换没有任何影响，且能把红指针前进到下一个
                // 如果红指针指向1，此时交换后红白指针指向的数据都符合要求，共同前进继续处理下一个
                swap(nums, white, red);
                red++;
                white++;
            } else if (nums[white] == 1) {
                // 如果已经是白色了，则白指针++
                white++;
            } else if (nums[white] == 2) {
                // 如果白指针指向蓝色，则跟蓝指针交换。蓝指针此时一定对，因为2都要在后面，填一个2以后，蓝指针--
                swap(nums, white, blue);
                blue--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{1, 1, 1, 2, 2, 0, 1, 2};
        sortColors(nums);
        Object[] x = Arrays.stream(nums).mapToObj(String::valueOf).toArray();
        System.out.println(StringUtils.join(x, ","));

    }
}

