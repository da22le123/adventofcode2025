package org.example.day4;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.List;

public class PrintingDepartmentPart1 extends Puzzle {
    public PrintingDepartmentPart1(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        int res = 0;
        char[][] matrix = populate(aocInput.lines());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '@')
                    res = canAccess(i, j, matrix) ? res + 1 : res;
            }
        }

        return res;
    }

    char[][] populate(List<String> lines) {
        char[][] matrix = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i).toCharArray();
        }

        return matrix;
    }

    boolean canAccess(int i, int j, char[][] matrix) {
        int count = 0;

        if (hasAt(i+1, j, matrix)) count++;
        if (hasAt(i-1, j, matrix)) count++;
        if (hasAt(i, j-1, matrix)) count++;
        if (hasAt(i, j+1, matrix)) count++;
        if (hasAt(i-1, j-1, matrix)) count++;
        if (hasAt(i+1, j+1, matrix)) count++;
        if (hasAt(i-1, j+1, matrix)) count++;
        if (hasAt(i+1, j-1, matrix)) count++;

        //System.out.println("Count surrounding: " + count);
        return count < 4;
    }

    boolean hasAt(int i, int j, char[][] matrix) {
        try {
            return matrix[i][j] == '@';
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

}
