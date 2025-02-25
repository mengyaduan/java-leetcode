package LcSpring100;

public class No162FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int l = 1, r = len - 2;
        // 这里已知两侧分别为 上升 和 下降 的趋势了
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid - 1]) {
                // 如果当前是下降趋势，左侧存在峰值
                r = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                // 如果当前是上升趋势，右侧存在峰值
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;


    }

}
