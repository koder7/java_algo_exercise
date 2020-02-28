package problems.leetcode.interviewCollection.array;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //validate rows
        for (int row = 0; row < board.length; row++) {
            HashSet<Character> set = new HashSet<>();
            for (int column = 0; column < board[row].length; column++) {
                char c = board[row][column];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        //validate columns
        for (int column = 0; column < board[0].length; column++) {
            HashSet<Character> set = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                char c = board[row][column];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        //validate zones
        int n = board.length;
        int zone = (int) Math.sqrt(n);

        int rowZone = zone;
        int colZone = zone;

        while (rowZone <= n) {
            int rowStart = rowZone - zone;
            colZone = zone;
            while (colZone <= n) {
                int colStart = colZone - zone;
                HashSet<Character> set = new HashSet<>();
                for (int row = rowStart; row < rowZone; row++) {
                    for (int col = colStart; col < colZone; col++) {
                        char c = board[row][col];
                        if (c != '.') {
                            if (set.contains(c)) {
                                return false;
                            } else {
                                set.add(c);
                            }
                        }
                    }
                }
                colZone += zone;
            }
            rowZone += zone;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku sol = new ValidSudoku();
//        System.out.println(sol.isValidSudoku(new char[][]{new char[]{'8','3','.','.','7','.','.','.','.'},
//                new char[]{'6','.','.','1','9','5','.','.','.'},
//                new char[]{'.','9','8','.','.','.','.','6','.'},
//                new char[]{'8','.','.','.','6','.','.','.','3'},
//                new char[]{'4','.','.','8','.','3','.','.','1'},
//                new char[]{'7','.','.','.','2','.','.','.','6'},
//                new char[]{'.','6','.','.','.','.','2','8','.'},
//                new char[]{'.','.','.','4','1','9','.','.','5'},
//                new char[]{'.','.','.','.','8','.','.','7','9'}}));

//        System.out.println(sol.isValidSudoku(new char[][] {
//                new char[] {'.','.','.','.','5','.','.','1','.'},
//                new char[] {'.','4','.','3','.','.','.','.','.'},
//                new char[] {'.','.','.','.','.','3','.','.','1'},
//                new char[] {'8','.','.','.','.','.','.','2','.'},
//                new char[] {'.','.','2','.','7','.','.','.','.'},
//                new char[] {'.','1','5','.','.','.','.','.','.'},
//                new char[] {'.','.','.','.','.','2','.','.','.'},
//                new char[] {'.','2','.','9','.','.','.','.','.'},
//                new char[] {'.','.','4','.','.','.','.','.','.'}}));

        System.out.println(sol.isValidSudoku(new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                new char[]{'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '5', '2', '.', '.'}}));
    }
}
