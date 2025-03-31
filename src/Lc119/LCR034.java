package Lc119;

public class LCR034 {
    public boolean isAlienSorted(String[] words, String order) {
        boolean result = true;
        for (int i = 1; i < words.length; i++) {
            result &= compare(words[i - 1], words[i], order);
            if (!result) {
                return false;
            }
        }
        return result;
    }

    private boolean compare(String a, String b, String order) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int i = 0, j = 0;
        while (i < ac.length && j < bc.length) {
            if (order.indexOf(ac[i]) < order.indexOf(bc[j])) {
                return true;
            } else if (order.indexOf(ac[i]) == order.indexOf(bc[j])) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return ac.length == bc.length || j < bc.length;
    }

}
