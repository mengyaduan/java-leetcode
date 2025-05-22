package Lc119;

public class LCR091 {

    int[][] tb;

    public int minCost(int[][] costs) {
        tb = new int[costs.length][3];
        tb[0][0] = costs[0][0];
        tb[0][1] = costs[0][1];
        tb[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            tb[i][0] = costs[i][0] + Math.min(tb[i - 1][1], tb[i - 1][2]);
            tb[i][1] = costs[i][1] + Math.min(tb[i - 1][0], tb[i - 1][2]);
            tb[i][2] = costs[i][2] + Math.min(tb[i - 1][0], tb[i - 1][1]);
        }
        return Math.min(tb[costs.length - 1][0], Math.min(tb[costs.length - 1][1], tb[costs.length - 1][2]));
    }

}
