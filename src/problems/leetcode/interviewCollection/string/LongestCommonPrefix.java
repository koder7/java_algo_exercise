package problems.leetcode.interviewCollection.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        int n = strs.length;

        //find max len
        for (String str: strs) {
            minLength = Math.min(minLength, str.length());
        }

        if(minLength == 0 || n == 0) return "";
        int index = 0;
        int currentCount = 0;
        boolean loopCondition = true;
        for (int j = 0; j < minLength; j++) {
             for (int i = 0; i < n; i++) {
                if (index < minLength) {
                    char c = strs[0].charAt(index);
                    if (c == strs[i].charAt(index)) {
                        currentCount++;
                    } else {
                        return sb.toString();
                    }
                    if (currentCount == n) {
                        sb.append(c);
                        currentCount = 0;
                        index++;
                    }
                }
            }
        }
        return sb.toString();
    }

    //Simpler version of same code
    public String longestCommonPrefixSimple(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower","f","flight"}));
        System.out.println(sol.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(sol.longestCommonPrefix(new String[]{}));

    }
}
