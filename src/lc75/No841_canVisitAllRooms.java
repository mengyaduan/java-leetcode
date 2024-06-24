package lc75;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75">钥匙和房间</a>
 */
public class No841_canVisitAllRooms {
    int[] hasOpened;
    int openedNum;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        hasOpened = new int[n];
        hasOpened[0] = 1;
        openedNum = 1;
        visit(rooms.get(0), rooms);
        return openedNum == n;
    }

    public void visit(List<Integer> toBeVisited, List<List<Integer>> rooms) {
        if (openedNum == hasOpened.length) {
            return;
        }
        List<Integer> toBeVisitedNew = new ArrayList<>();
        for (int node : toBeVisited) {
            if (hasOpened[node] == 0) {
                hasOpened[node] = 1;
                openedNum++;
                visit(rooms.get(node), rooms);
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(2, 3)));
        rooms.add(new ArrayList<>(Arrays.asList()));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(1, 3)));

        System.out.println(canVisitAllRooms(rooms));


    }
}
