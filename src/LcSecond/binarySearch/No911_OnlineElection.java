package LcSecond.binarySearch;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/online-election/description/">在线选举</a>
 **/
public class No911_OnlineElection {
    @Test(description = "")
    public void test() throws Exception {
        int[] persons = new int[]{0, 1, 1, 0, 0, 1, 0};
        int[] times = new int[]{0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate x = new TopVotedCandidate(persons, times);
        System.out.println(x.q(3));
        System.out.println(x.q(12));
        System.out.println(x.q(25));
        System.out.println(x.q(15));
        System.out.println(x.q(24));
        System.out.println(x.q(8));

    }

    @Test(description = "")
    public void test2() throws Exception {
        int[] persons = new int[]{
                0, 0, 0, 1, 1, 2, 2, 2, 3, 4, 1, 3, 5, 5, 3, 6, 5, 4, 6, 7, 7, 4, 7, 6, 7, 3, 1, 8, 4, 9, 0, 10, 5, 2, 10, 8, 10, 9, 10, 6, 8, 9, 8, 9, 11, 11, 11, 11, 12, 12, 12, 12, 6, 2, 5, 7, 13, 9, 0, 12, 10, 8, 11, 1, 4, 3, 13, 13, 13, 13, 12, 6, 3, 9, 1, 10, 14, 2, 0, 4, 13, 11, 7, 8, 5, 14, 14, 14, 14, 14, 9, 8, 14, 13, 10, 5, 12, 6, 2, 1
        };
        int[] times = new int[]{
                352, 401, 485, 646, 652, 944, 1287, 1292, 1318, 1337, 1347, 1398, 1454, 1502, 1559, 1709, 1786, 2245, 2255, 2677, 2787, 2886, 2918, 3202, 3314, 3457, 3475, 3560, 3602, 3740, 3816, 3829, 3841, 3842, 3930, 3943, 4049, 4056, 4206, 4292, 4367, 4457, 4576, 4586, 4632, 4637, 4710, 4915, 5104, 5153, 5204, 5223, 5475, 5503, 5531, 5600, 5685, 5692, 5813, 5909, 5939, 6186, 6370, 6457, 6675, 6680, 6720, 6734, 6754, 6985, 7102, 7106, 7121, 7142, 7405, 7440, 7517, 7590, 7863, 8017, 8083, 8088, 8164, 8176, 8303, 8477, 8511, 8665, 8691, 8823, 9115, 9123, 9260, 9446, 9450, 9629, 9636, 9703, 9868, 9997
        };
        TopVotedCandidate x = new TopVotedCandidate(persons, times);
        System.out.println(x.q(4389));


    }


    @Test(description = "")
    public void test3() throws Exception {
        int[] persons = new int[]{
                0, 0, 0, 1, 1, 2, 2, 2, 3, 4, 1, 3, 5, 5, 3, 6, 5, 4, 6, 7
        };
        int[] times = new int[]{
                352, 401, 485, 646, 652, 944, 1287, 1292, 1318, 1337, 1347, 1398, 1454, 1502, 1559, 1709, 1786, 2245, 2255, 2677
        };
        TopVotedCandidate x = new TopVotedCandidate(persons, times);
        System.out.println(x.q(2132));


    }

}

class TopVotedCandidate {

    int[] votesWinner;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int n = times.length;
        int[] voteNum = new int[n];
        votesWinner = new int[n];
        int top = -1;
        // times是升序的，从头开始归票
        for (int i = 0; i < n; i++) {
            int candidate = persons[i];
            voteNum[candidate] += 1;
            if (voteNum[candidate] >= top) {
                top = voteNum[candidate];
                votesWinner[i] = candidate;
            } else {
                votesWinner[i] = votesWinner[i - 1];
            }
        }
        System.out.println(voteNum);
    }

    public int q(int t) {
        int n = votesWinner.length;
        int l = 0, r = n - 1;
        int target = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (times[mid] <= t) {
                target = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return votesWinner[target];
    }
}
