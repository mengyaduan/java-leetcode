package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No151ReverseWords {

    /**
     * 正确答案
     * 第一步，合并空格
     * 第二步，反转合并后的整个char[]
     * 第三步，按照单词再次反转
     */

    public String reverseWords(String s) {
        // step1
        int slow = 0;
        int fast = 0;
        char[] arr = s.toCharArray();
        boolean hasAdd = true;
        int len = 0;
        while (fast < arr.length) {
            if (arr[fast] != ' ') {
                hasAdd = false;
                arr[slow] = arr[fast];
                slow++;
                len = slow;
            } else if (arr[fast] == ' ' && !hasAdd) {
                hasAdd = true;
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        // step2
        reverseCharArr(arr, 0, len - 1);
        // step3
        slow = 0;
        fast = 0;
        while (fast < len) {
            while (fast < len && arr[fast] != ' ') {
                fast++;
            }
            reverseCharArr(arr, slow, fast - 1);
            fast += 1;
            slow = fast;
        }
        StringBuilder res = new StringBuilder();
        return res.append(arr, 0, len).toString();
    }

    private void reverseCharArr(char[] arr, int i, int j) {
        while (i < j) {
            char x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
            i++;
            j--;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(reverseWords("the sky is blue") + ",");
        System.out.println(reverseWords("  hello world  ") + ",");
        System.out.println(reverseWords("a good   example") + ",");

    }
}
