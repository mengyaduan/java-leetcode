package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int idx = s.length() - 1;
        int count = 0;
        char[] ca = s.toCharArray();
        while (ca[idx] == ' ') {
            idx--;
        }
        while (idx >= 0 && ca[idx] != ' ') {
            count++;
            idx--;
        }
        return count;
    }

}
