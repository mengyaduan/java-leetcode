package LcSecond.simulation;

/**
 * @see <a href="https://leetcode.cn/problems/find-champion-i/description/?envType=daily-question&envId=2024-04-12">找到冠军</a>
 **/
public class No2923_FindChampion {
    public int findChampion(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int countItem = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (i != j && grid[i][j] == 0) {
                    break;
                }
                countItem++;
            }
            if (countItem == grid.length) {
                return i;
            }
        }
        return -1;
    }
}
