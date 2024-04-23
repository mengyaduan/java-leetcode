package LcSecond.binarySearch;

/**
 * @see <a href="https://leetcode.com/problems/reach-a-number/">到达终点数字</a>
 **/
public class No754_ReachANumber {

    /**
     * 直接看的答案，数学题！
     **/

    /**
     * @see <a href="https://leetcode.cn/problems/reach-a-number/solutions/1947254/fen-lei-tao-lun-xiang-xi-zheng-ming-jian-sqj2/">题解</a>
     **/
    public int reachNumber(int target) {
        target = Math.abs(target);
        int n = (int) Math.ceil((-1 + Math.sqrt(8L * target + 1)) / 2); // 注意 8*target 会超过 int 范围
        return (n * (n + 1) / 2 - target) % 2 == 0 ? n : n + 1 + n % 2;
    }

}
