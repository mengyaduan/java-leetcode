package LC100Again;



public class Lc083 {

    public int rob(int[] nums) {
        int steal = nums[0];
        int stay = 0;
        for (int i = 1; i < nums.length; i++) {
            int stealNew = stay + nums[i];
            int stayNew = Math.max(stay, steal);
            steal = stealNew;
            stay = stayNew;
        }
        return Math.max(steal, stay);
    }


}
