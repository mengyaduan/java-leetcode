import org.testng.annotations.Test;

/**
 * @author yameng.dym
 * 快速排序
 **/
public class QuickSortJava {
    public void qsLR(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int pivot = nums[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        System.out.println("本轮：l=" + l + "  r=" + r + "  pivot=" + pivot);
        nums[l] = nums[i];
        nums[i] = pivot;

        printNum(nums);
        qsLR(nums, l, i - 1);
        qsLR(nums, i + 1, r);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void printNum(int[] nums) {
        for (int item : nums) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 8};
        int[] nums2 = new int[]{0, 1, 3, 2};
        qsLR(nums, 0, nums.length - 1);
    }
}
