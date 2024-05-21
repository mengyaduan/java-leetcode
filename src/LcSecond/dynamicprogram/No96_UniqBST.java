package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/description/">二叉搜索树的数量</a>
 */
public class No96_UniqBST {
    int[] memo;

    public int numTrees(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        return number(n);
    }

    public int number(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        int sum = 0;
        // 区分奇数偶数，减少循环
        boolean isOdd = n % 2 != 0;
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            sum += number(i) * number(n - 1 - i) * 2;
        }
        if (isOdd) {
            sum += number(mid) * number(mid);
        }
        memo[n] = sum;
        return sum;
    }

    @Test(description = "")
    public void testr() throws Exception {
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));

    }
}
