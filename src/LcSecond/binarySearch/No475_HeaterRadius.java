package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/heaters/description/">加热器半径</a>
 **/
public class No475_HeaterRadius {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int nHouse = houses.length;
        int nHeater = heaters.length;
        // heater和houses分为五种场景
        if (heaters[nHeater - 1] < houses[0]) {
            // 所有heater都在house左边
            return houses[nHouse - 1] - heaters[nHeater - 1];
        }
        if (heaters[0] > houses[nHouse - 1]) {
            // 所有heater都在house右边
            return heaters[0] - houses[0];
        }
        int leftRad = 0;
        int rightRad = Integer.MAX_VALUE;
        if (heaters[nHeater - 1] >= houses[0] && heaters[0] < houses[0]) {
            // heater左侧交于houses
            rightRad = Math.max(Math.abs(heaters[nHeater - 1] - houses[0]), Math.abs(heaters[nHeater - 1] - houses[nHouse - 1]));
        } else if (heaters[0] <= houses[nHouse - 1] && heaters[nHeater - 1] > houses[nHouse - 1]) {
            // heater右侧交于houses
            rightRad = Math.max(Math.abs(heaters[0] - houses[0]), Math.abs(heaters[0] - houses[nHouse - 1]));
        } else {
            // heater在house中间
            rightRad = Math.max(Math.abs(heaters[0] - houses[nHouse - 1]), Math.abs(heaters[nHeater - 1] - houses[0]));
        }
        int res = rightRad;
        while (leftRad <= rightRad) {
            int mid = leftRad + (rightRad - leftRad) / 2;
            if (checkCoverAll(houses, heaters, mid)) {
                res = Math.min(res, mid);
                rightRad = mid - 1;
            } else {
                leftRad = mid + 1;
            }
        }
        return res;
    }

    public boolean checkCoverAll(int[] houses, int[] heaters, int rad) {
        int heaterIndex = 0;
        int houseIndex = 0;
        while (heaterIndex < heaters.length) {
            while (Math.abs(houses[houseIndex] - heaters[heaterIndex]) <= rad) {
                houseIndex++;
                if (houseIndex == houses.length){
                    return true;
                }
            }
            heaterIndex++;
        }
        return false;
    }


    @Test(description = "")
    public void test3() throws Exception {
        int[] houses = new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int[] heaters = new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
        System.out.println(findRadius(houses, heaters));
    }

    @Test(description = "")
    public void test2() throws Exception {
        int[] houses = new int[]{1, 2, 3, 4};
        int[] heaters = new int[]{1, 4};
        System.out.println(findRadius(houses, heaters));
    }

    @Test(description = "")
    public void test1() throws Exception {
        int[] houses = new int[]{1};
        int[] heaters = new int[]{1, 2, 3, 4};
        System.out.println(findRadius(houses, heaters));
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] houses = new int[]{1, 5};
        int[] heaters = new int[]{2};
        System.out.println(findRadius(houses, heaters));
    }


}
