package problems.leetcode.random;

import problems.leetcode.recursion.MatchPow;

import java.util.Arrays;

public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String S, char C) {
        if(S.isEmpty() || S == null) {
            return null;
        }
        int n = S.length();
        int[] output = new int[n];
        int prev = Integer.MIN_VALUE/2;
        for (int i = 0; i < n; i++) {
            if(S.charAt(i) == C) {
                prev = i;
            }
            output[i] = i - prev;
        }
        prev = Integer.MAX_VALUE;
        for (int i = n-1; i >= 0 ; i--) {
            if(S.charAt(i) == C) {
                prev = i;
            }
            output[i] = Math.min(output[i], prev-i);
        }
        return output;
    }

    public static void main(String[] args) {
        ShortestDistanceToCharacter p = new ShortestDistanceToCharacter();

        System.out.println(Arrays.toString(p.shortestToChar("loveleetcode", 'e')));
    }
}
