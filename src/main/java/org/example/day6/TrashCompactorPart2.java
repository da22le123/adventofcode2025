package org.example.day6;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("D")
public class TrashCompactorPart2 extends Puzzle {
    public TrashCompactorPart2(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        List<String> lines = aocInput.lines();
        char[][] homework = new char[lines.size()][];

        // populate
        for (int i = 0; i < lines.size(); i++) {
            homework[i] = lines.get(i).toCharArray();
        }


        printHomework(homework);

        long sum = 0;

        List<Long> operands = new ArrayList<>();
        for (int i = homework[0].length -1; i >= 0; i--) {
            boolean wasPlus = false;
            boolean wasAsterisk = false;

            StringBuilder operandB = new StringBuilder();
            for (int j = 0; j < homework.length; j++) {
                char c = homework[j][i];
                System.out.println("accessed char: " + c);
//                if (Character.i)
                if (Character.isDigit(c)){
                    operandB.append(c);
                    continue;
                }

                wasPlus = c == '+';
                wasAsterisk = c == '*';
            }
            if (!operandB.isEmpty()) {
                System.out.println(operandB);
                operands.add(Long.parseLong(operandB.toString()));
            }
            if (wasPlus) {
                System.out.println("encountered '+'");
                for (long operand : operands) {
                    sum += operand;
                }
                System.out.println("new sum = " + sum);
                operands.clear();
            } else if (wasAsterisk) {
                System.out.println("encountered '*'");
                long res = 1;
                for (long operand : operands) {
                    res *= operand;
                }
                sum += res;
                System.out.println("new sum = " + sum);
                operands.clear();
            }
        }




        //printHomework(homework);
        return sum;
    }

    void printHomework(char[][] homework) {
        for (int i = 0; i < homework.length; i++) {
            for (int j = 0; j < homework[i].length; j++) {
                System.out.print(homework[i][j] + " ");
            }
            System.out.println();
        }
    }
}
