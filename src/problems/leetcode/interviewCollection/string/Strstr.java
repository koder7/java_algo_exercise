package problems.leetcode.interviewCollection.string;

public class Strstr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int L = needle.length(), n = haystack.length();
        int needleIndex = 0;
        for (int i = 0; i < n-L+1; i++) {
            while (i < haystack.length() && haystack.charAt(i) == needle.charAt(needleIndex)) {
                if (needleIndex == needle.length() - 1) {
                    return i - needleIndex;
                }
                i++;
                needleIndex++;
            }
            if(needleIndex != 0) {
                i = i - needleIndex;
                needleIndex = 0;
            }
        }
     return -1;
    }

    //Better structured
    public int strStrSolution(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }

    //Another solution Rabin Carp with rolling hash

    public static void main(String[] args) {
        Strstr sol = new Strstr();
        System.out.println(sol.strStr("mississippi", "pi"));
        System.out.println(sol.strStr("mississippi", "issip"));
        System.out.println(sol.strStr("a", "a"));
        System.out.println(sol.strStr("hello", "ll"));
        System.out.println(sol.strStr("hello", ""));
        System.out.println(sol.strStr("aaaaa", "bba"));
        System.out.println(sol.strStr("", "a"));
        System.out.println(sol.strStr("mississippi", "issipi"));
    }
}
