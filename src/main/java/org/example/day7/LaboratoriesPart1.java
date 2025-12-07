package org.example.day7;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.List;

@SuppressWarnings("D")
public class LaboratoriesPart1 extends Puzzle {
    public LaboratoriesPart1(AocInput aocInput) {
        super(aocInput);
    }

    @Override
    public Object solve() {
        List<String> input = aocInput.lines();

        char[][] diagram = new char[input.size()][];

        for (int i = 0; i < input.size(); i++) {
            diagram[i] = input.get(i).toCharArray();
        }


        int splitCount = 0;
        printChars(diagram);

        for (int i = 0; i < diagram[0].length; i++) {
            if (diagram[0][i] == 'S') {
                diagram[1][i] = '|';
            }
        }

        for (int i = 1; i < diagram.length; i++ ) {
            for (int j = 0; j < diagram[i].length; j++) {
                if (diagram[i][j] == '^') {
                    if (diagram[i - 1][j] == '|') {
                        splitCount++;
                        // right
                        if (j < diagram[i].length - 1 && diagram[i][j + 1] == '.') {
                            diagram[i][j + 1] = '|';
                        }
                        // left
                        if (j > 0 && diagram[i][j - 1] == '.') {
                            diagram[i][j - 1] = '|';
                        }
                    }
                }
            }


            for (int j = 0; j < diagram[i].length; j++) {
                if (diagram[i][j] == '|') {
                    int copyI = i;
                    while (copyI < diagram.length - 1 && diagram[copyI + 1][j] == '.') {
                        diagram[copyI + 1][j] = '|';
                        copyI++;
                    }
                }
            }
        }

        printChars(diagram);
        return splitCount;
    }



    boolean contains(char[] array, char key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return true;
            }
        }

        return false;
    }

    void printChars(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
