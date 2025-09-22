package LC100Again;


public class Lc096 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int item: nums){
            res ^= item;
        }
        return res;
    }

}
