package LcSpring100;

public class No69MySqrt {

    public int mySqrt(int x) {
        int l = 0;
        int r = Math.min(x, 46340);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
