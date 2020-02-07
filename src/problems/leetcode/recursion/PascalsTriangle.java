package problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PascalsTriangle {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> pascalList = new ArrayList<>();
            for(int i = 1; i <= numRows; i++) {
                List<Integer> rowList = new ArrayList<Integer>();
                for(int j = 1; j <= i; j++) {
                    if(i == j || j == 1) {
                        rowList.add(1);
                    } else {
                        rowList.add(pascal(i,j));
                    }
                }
                pascalList.add(rowList);
            }
            return pascalList;
        }

        private int pascal(int rowNum, int colNum) {
            if(colNum == 1 || (rowNum == colNum)) {
                return 1;
            }
            return pascal(rowNum-1, colNum -1) + pascal(rowNum-1, colNum);
        }

        private void printPascalList(List<List<Integer>> pascalList) {
            System.out.println(pascalList.stream());
        }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();

        pascalsTriangle.generate(3).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
