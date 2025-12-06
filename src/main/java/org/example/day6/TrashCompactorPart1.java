package org.example.day6;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrashCompactorPart1 extends Puzzle {
    public TrashCompactorPart1(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        List<String[]> homework = new ArrayList<>();

        for (String line: aocInput) {
            homework.add(line.trim().replaceAll("\\s+", " ").split(" "));
        }

        printHomework(homework);
        long sum = 0;

        for (int i = 0; i < homework.get(0).length; i++) { // array level
            char operator = homework.getLast()[i].charAt(0);
            int[] operands = new int[homework.size()-1];

            for (int j = 0; j < homework.size() -1; j++) { // list level, populate operands
                operands[j] = Integer.parseInt(homework.get(j)[i]);
            }

            if (operator == '*') {
                long res = 1;
                for (int operand : operands) {
                    res *= operand;
                }
                sum += res;
            } else if (operator == '+') {
                for (int operand : operands) {
                    sum += operand;
                }
            }
        }

        return sum;
    }

    void printHomework(List<String[]> homework) {
        int sum = 0;
        for (String[] line: homework) {
            sum++;
            System.out.println("Length of the line: " + line.length);
            System.out.println(Arrays.toString(line));
        }
        System.out.println("Number of lines: " + sum);

    }
}
