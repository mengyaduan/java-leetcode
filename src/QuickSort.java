import org.testng.annotations.Test;

/**
 * @author yameng.dym
 * 快速排序
 **/
public class QuickSort {

    /**
     * 左闭右闭的上下限
     **/
    public void quickSort(int[] nums, int l, int r) {
        int i = l;
        int j = r - 1;
        int key = nums[i];
        if (l + 1 >= r) {
            return;
        }
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        for (int item : nums) {
            System.out.print(item + " ");
        }
        System.out.println();
        quickSort(nums, l, i);
        quickSort(nums, i + 1, r);

    }


    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        quickSort(nums, 0, nums.length);

    }
}
