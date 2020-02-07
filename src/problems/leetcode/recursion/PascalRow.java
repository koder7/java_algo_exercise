package problems.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalRow {

    public List<Integer> getRow(int rowIndex) {
        Map<String, Integer> lookupMap = new HashMap<>();

        List<Integer> pascalList = new ArrayList<>();
        //increase row index
        rowIndex++;
        for (int colIndex = 1; colIndex <= rowIndex; colIndex++) {
            if (rowIndex == colIndex || colIndex == 1) {
                pascalList.add(1);
            } else {
                int result = pascal(rowIndex, colIndex, lookupMap);
                pascalList.add(result);
            }
        }
        return pascalList;
    }

    private int pascal(Integer rowNum, Integer colNum, Map<String, Integer> lookupMap) {
        if (colNum == 1 || (rowNum.equals(colNum))) {
            return 1;
        }
        int result;
        if(lookupMap.containsKey(rowNum.toString() + colNum)) {
            result = lookupMap.get(rowNum.toString() + colNum);
        } else {
            result = pascal(rowNum - 1, colNum - 1, lookupMap) + pascal(rowNum - 1, colNum, lookupMap);
            lookupMap.put(rowNum.toString() + colNum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalRow pascalRow = new PascalRow();
        System.out.println(pascalRow.getRow(22));
    }

    // Thought of using a tuple but its not native to java
    // Just got an idea to convert it to string, made a string, integer map
}
