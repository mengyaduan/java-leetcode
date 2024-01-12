package Lc.KrahetsInterview.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static DataStruct.tools.string2IntArray;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/description/">找到第K大的数</a>
 **/
public class No215Answer {

    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        return findK(numbers, k);
    }

    private int findK(ArrayList<Integer> numbers, int k) {
        // 随便找一个坐标
        Random random = new Random();
        int pivot = numbers.get(random.nextInt(numbers.size()));

        ArrayList<Integer> bigger = new ArrayList<>();
        ArrayList<Integer> smaller = new ArrayList<>();

        for (int num : numbers) {
            if (num > pivot) {
                bigger.add(num);
            } else if (num < pivot) {
                smaller.add(num);
            }
        }

        if (bigger.size() >= k) {
            return findK(bigger, k);
        }
        if (numbers.size() - smaller.size() < k) {
            return findK(smaller, k - (numbers.size() - smaller.size()));
        }
        return pivot;

    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = string2IntArray("3,2,3,1,2,4,5,5,6");
        int res = findKthLargest(nums, 4);
        Assert.assertEquals(res, 4);

    }

}

