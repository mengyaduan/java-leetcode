package lc75;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75">dota参议院</a>
 */
public class No649_predictPartyVictory {

    public String predictPartyVictory(String senate) {
        int r = 0, d = 0;
        char[] cs = senate.toCharArray();
        Deque<Character> helper = new ArrayDeque<>();
        StringBuilder nextRound = new StringBuilder();
        for (char c : cs) {
            if (helper.isEmpty() || helper.peekLast() == c) {
                nextRound.append(c);
                helper.push(c);
                if (c == 'R') {
                    r++;
                } else {
                    d++;
                }
            } else {
                helper.pollLast();
            }
        }
        while (!helper.isEmpty()) {
            nextRound.insert(0, helper.pollLast());
            nextRound.deleteCharAt(nextRound.length() - 1);
        }
        if (r == 0 || d == 0) {
            return nextRound.toString().charAt(0) == 'R' ? "Radiant" : "Dire";
        }
        return predictPartyVictory(nextRound.toString());
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(predictPartyVictory("RDDRR"));
        System.out.println(predictPartyVictory("RDDDRRRRDD"));
        System.out.println(predictPartyVictory("RDD"));

    }
}
