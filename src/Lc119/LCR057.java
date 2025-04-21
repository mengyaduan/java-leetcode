package Lc119;

import java.util.HashMap;

public class LCR057 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 滑动窗口遍历，计算每个数据的桶号
        HashMap<Long, Long> helper = new HashMap<>();

        //桶的大小为t+1，允许最大元素和最小元素之差为t
        long w = (long) t + 1;

        // 对每个数据进行分桶，每t个一桶，item = (0,t+1)*a + b
        for (int i = 0; i < nums.length; i++) {
            long idx = getIdx(nums[i], t);
            if (helper.containsKey(idx)) {
                return true;
            }
            //前一个桶有一个元素，并且值的范围符合要求
            if (helper.containsKey(idx - 1) && Math.abs(nums[i] - helper.get(idx - 1)) < w) {
                return true;
            }
            //前一个桶有一个元素，并且值的范围符合要求
            if (helper.containsKey(idx + 1) && Math.abs(nums[i] - helper.get(idx + 1)) < w) {
                return true;
            }
            helper.put(idx, (long) nums[i]);
            if (i - k >= 0) {
                long idxR = getIdx(nums[i - k], w);
                helper.remove(idxR);
            }
        }
        return false;
    }

    /**
     * 如果是非负数，桶号 = nums[i] / (t+1)
     * 如果是负数，桶号 = nums[i] / (-t-1)
     */
    private long getIdx(long item, long w) {
        if (item >= 0) {
            return item / w;
        }
        return (item + 1) / (w - 1);
    }

}
