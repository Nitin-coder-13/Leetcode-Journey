package DynamicProgramming;

import java.util.*;

public class Pascals_Triangle {
    public static void main(String[] args) {
      System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        if (numRows == 1) return result;
        for (int i = 1; i < numRows; i++) {
            List<Integer> PrevRow = result.get(i - 1);
            // start the next row
            ArrayList<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 0; j < i - 1; j++) {
                currRow.add(PrevRow.get(j) + PrevRow.get(j + 1));
            }
            currRow.add(1);
            result.add(currRow);

        }
        return result;
    }
}
