package lc75;

/**
 * @see <a href="https://leetcode.cn/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75">猜大小</a>
 */
public class No374_guessNumber {

    public int guessNumber(int n) {
        int min = 0, max = n;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int tmp = guess(mid);
            if (tmp == 0) {
                return mid;
            } else if (tmp == -1) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return 0;
    }

    private int guess(int mid) {
        return 0;
    }


}
