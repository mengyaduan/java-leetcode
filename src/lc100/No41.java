package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.HashMap;
import java.util.HashSet;

public class No41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int targetIdx = nums[i] - 1;
            while (targetIdx < n && targetIdx >= 0 && nums[i] != i + 1 && nums[targetIdx] != nums[i]) {
                // 如果nums[i]=4，那应该把4放进nums[3]里面
                int temp = nums[targetIdx];
                nums[targetIdx] = nums[i];
                nums[i] = temp;
                // 更新目标
                targetIdx = nums[i] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(firstMissingPositive(new int[]{1, 1}), 2);
        Assert.assertEquals(firstMissingPositive(new int[]{3, 4, -1, 1}), 2);
        Assert.assertEquals(firstMissingPositive(new int[]{4, 67, 7, 8, 9, 2, 1, 5, 3}), 6);
        Assert.assertEquals(firstMissingPositive(new int[]{1}), 2);

    }
}
