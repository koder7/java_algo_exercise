package problems.leetcode.divideandconquer;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int column = 0;

        while( row >= 0 && column < matrix[0].length) {
            if(matrix[row][column] > target) {
                row--;
            } else if( matrix[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }

}
