package problems.leetcode.interviewCollection.SortingandSearching;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import java.util.Random;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        long p = n / 2;
        int start = 0;
        int end = n;
        while (start < end ) {
            if (isBadVersion((int) p)) {
                end = (int) p;
                p = (start + p) / 2;
            } else {
                start = (int) p + 1;
                p = (end + p) / 2;
            }
        }
        return start;
    }

    public int firstBadVersionSimple(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    //        2126753390
//        1702766719
    private boolean isBadVersion(int version) {
        if (version > 6)
            return true;
        return false;
    }

    public static void main(String[] args) {
        FirstBadVersion sol = new FirstBadVersion();
        System.out.println(sol.firstBadVersion(23));
    }
}
