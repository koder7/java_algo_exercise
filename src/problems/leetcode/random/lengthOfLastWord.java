package problems.leetcode.random;

public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int n = s.length()-1;
        while(n>=0 && s.charAt(n) == ' ') {
            n--;
        }
        int res = 0;
        while(n >= 0 && s.charAt(n) != ' ') {
            n--;
            res++;
        }
        return res;
    }
}
