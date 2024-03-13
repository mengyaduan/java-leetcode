package Lc.dynamicprogramming;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-paths-with-max-score/description/"></a>
 **/
public class No1301_PathsWithMaxScore {
    int[][][] memo;
    int mod = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        memo = new int[n][n][2];
        memo[n - 1][n - 1][0] = 0;
        memo[n - 1][n - 1][1] = 1;
        // 初始化右边界和下边界
        boolean connectedFromS = true;
        for (int i = n - 2; i >= 0; i--) {
            // 处理最右侧列
            char s = board.get(i).charAt(n - 1);
            if (connectedFromS && s != 'X') {
                memo[i][n - 1][0] = memo[i + 1][n - 1][0] + (s - '0');
                memo[i][n - 1][1] = 1;
            } else {
                connectedFromS = false;
                memo[i][n - 1][1] = 0;
            }
        }
        showMemo(memo);
        connectedFromS = true;
        for (int i = n - 2; i >= 0; i--) {
            // 处理最下行
            char s = board.get(n - 1).charAt(i);
            if (connectedFromS && s != 'X') {
                memo[n - 1][i][0] = memo[n - 1][i + 1][0] + (s - '0');
                memo[n - 1][i][1] = 1;
            } else {
                connectedFromS = false;
                memo[n - 1][i][0] = 0;
                memo[n - 1][i][1] = 0;
            }
        }
        showMemo(memo);
        // 有了最右侧列和最底层行，可以开始计算其他数据了
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                char nowAt = board.get(i).charAt(j);
                if (nowAt == 'X') {
                    memo[i][j][0] = 0;
                    memo[i][j][1] = 0;
                } else {
                    int nowAtInt = nowAt == 'E' ? 0 : nowAt - '0';
                    // 一定是右边，下边，右下角中的最大值，如果有相等的，将[1]位的值相加，然后mod
                    int r = memo[i][j + 1][0];
                    int b = memo[i + 1][j][0];
                    int br = memo[i + 1][j + 1][0];
                    if (r > b) {
                        if (r > br) {
                            // 取r， 且r必不可能是0
                            memo[i][j][0] = r + nowAtInt;
                            memo[i][j][1] = (memo[i][j + 1][1]) % mod;
                        } else if (r < br) {
                            // 取 br， 且br必不可能是0
                            memo[i][j][0] = br + nowAtInt;
                            memo[i][j][1] = (memo[i + 1][j + 1][1]) % mod;
                        } else {
                            // 取 r + br，r或br都不可能是0
                            memo[i][j][0] = br + nowAtInt;
                            memo[i][j][1] = (memo[i + 1][j + 1][1] + memo[i][j + 1][1]) % mod;
                        }
                    } else if (r < b) {
                        if (b > br) {
                            // 取b
                            memo[i][j][0] = b + nowAtInt;
                            memo[i][j][1] = (memo[i + 1][j][1]) % mod;
                        } else if (b < br) {
                            // 取br
                            memo[i][j][0] = br + nowAtInt;
                            memo[i][j][1] = (memo[i + 1][j + 1][1]) % mod;
                        } else {
                            // 取b+br
                            memo[i][j][0] = br + nowAtInt;
                            memo[i][j][1] = (memo[i + 1][j + 1][1] + memo[i + 1][j][1]) % mod;
                        }
                    } else {
                        // r == b
                        if (r > br) {
                            // 取 r+b
                            memo[i][j][0] = r + nowAtInt;
                            memo[i][j][1] = (memo[i][j + 1][1] + memo[i + 1][j][1]) % mod;
                        } else if (r < br) {
                            // 取br
                            memo[i][j][0] = br + nowAtInt;
                            memo[i][j][1] = (memo[i + 1][j + 1][1]) % mod;
                        } else {
                            // 取 r+b+br，此时有三种场景：
                            // 1. 都不是0，正常计算
                            // 2. 都是0，此时需要看[1]是否为0，因为(0,1)是‘S’，需要特殊处理
                            memo[i][j][1] = r == 0 ? Math.max(memo[i][j + 1][1], Math.max(memo[i + 1][j][1], memo[i + 1][j + 1][1])) : ((memo[i][j + 1][1] + memo[i + 1][j][1]) % mod + memo[i + 1][j + 1][1]) % mod;
                            memo[i][j][0] = memo[i][j][1] > 0 ? r + nowAtInt : 0;
                        }
                    }
                }
            }

            showMemo(memo);
        }
        return memo[0][0];
    }


    @Test(description = "")
    public void test() throws Exception {
        List<String> board = new ArrayList<>(Arrays.asList("E11", "XXX", "11S"));
        int[] m = pathsWithMaxScore(board);
        System.out.printf("最大值%d, 次数%d", m[0], m[1]);

    }

    public void showMemo(int[][][] xx) {
        System.out.println("=============================================");
        for (int[][] rows : xx) {
            ArrayList<String> newRow = new ArrayList<>();
            for (int[] row : rows) {
                newRow.add(String.format("(%d, %d)", row[0], row[1]));
            }
            System.out.println(StringUtils.join(newRow, "\t"));
        }

    }
}

