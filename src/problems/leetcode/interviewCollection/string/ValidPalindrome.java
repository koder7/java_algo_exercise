package problems.leetcode.interviewCollection.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start <= end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(!isAlphaNumeric(startChar)) {
                start++;
                continue;
            }
            if(!isAlphaNumeric(endChar) ) {
                end--;
                continue;
            }
            if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        if((c >= '0' && c <= '9') || (c >= 'A' && c<= 'Z')
            || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();

        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sol.isPalindrome("race a car"));
    }

}
