package lc100;

import java.util.ArrayList;

public class No279OverLimit {

    int result;

    public int numSquares(int n) {
        result = Integer.MAX_VALUE;
        ArrayList<Integer> squares = new ArrayList<>();
        int i = 1;
        int res = 1;
        squares.add(res);
        while (res < n) {
            i++;
            res = i * i;
            squares.add(res);
        }
        dp(squares, n, new ArrayList<>());
        return result;
    }

    private void dp(ArrayList<Integer> squares, int left, ArrayList<Integer> path) {
        if (left == 0) {
            result = Math.min(result, path.size());
            return;
        }
        for (int i = 0; i < squares.size(); i++) {
            int item = squares.get(i);
            if (left < item) {
                continue;
            }
            path.add(item);
            dp(squares, left - item, path);
            path.remove(path.size() - 1);
        }
    }
}
