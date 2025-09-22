package LC100Again;


public class Lc097 {

    public int majorityElement(int[] nums) {
        int x = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                x = nums[i];
                cnt++;
                continue;
            }
            if (nums[i] == x) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return x;
    }

}
