package problems.leetcode.interviewCollection.array;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(row <= col) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }

        //Reverse rows
        for (int row = 0; row < n; row++) {
            for (int colStart = 0, colEnd = n-1; colStart < n/2; colStart++, colEnd--) {
                int temp = matrix[row][colStart];
                matrix[row][colStart] = matrix[row][colEnd];
                matrix[row][colEnd] = temp;
            }
        }

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        RotateImage sol = new RotateImage();
        sol.rotate(new int[][] {
                new int[] { 5, 1, 9,11},
                new int[] { 2, 4, 8,10},
                new int[] {13, 3, 6, 7},
                new int[] {15,14,12,16}
        });
    }
}
