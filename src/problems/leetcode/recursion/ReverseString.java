package problems.leetcode.recursion;

public class ReverseString {
    public void reverseString(char[] s) {
        reverse(0, s.length-1, s);
        System.out.println(s);
    }

    private void reverse(int start, int end, char[] s) {
        if(start >= end) {
            return;
        }
        char t = s[start];
        s[start] = s[end];
        s[end] = t;
        reverse(++start, --end, s);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[] {'h', 'e', 'l', 'l', 'o'});
    }
}
