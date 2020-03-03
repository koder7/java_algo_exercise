package problems.leetcode.interviewCollection.string;

import com.sun.xml.internal.bind.v2.util.EditDistance;

public class CountAndSay {

    public String countAndSayIterative(int n) {
        String result = "1";
        if(n==1) return result;
        return countDigits(countAndSay(n-1));
    }


    public String countAndSay(int n) {
        return helper(n, "");
    }

    private String helper(int n, String s) {
        if(n==1)  return "1";
        while(n >= 0) {
           s = helper(n-1, s);
            return countDigits(s);
        }
        return s;
    }

    private String countDigits(String digits) {
        int n = digits.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            count = 0;
            while(i < n-1 && digits.charAt(i) == digits.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count+1)).append(digits.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();
        System.out.println(sol.countAndSay(5));
//        System.out.println(sol.countDigits("111221"));
        System.out.println(sol.countAndSayIterative(5));
    }
}
