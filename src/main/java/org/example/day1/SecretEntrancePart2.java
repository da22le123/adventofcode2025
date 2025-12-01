package org.example.day1;

import org.example.AocInput;
import org.example.Puzzle;

public class SecretEntrancePart2 extends Puzzle {
    public SecretEntrancePart2(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        int start = 50;
        int end;
        int solution = 0;

        for (String line : aocInput.lines()) {
            if (line.isBlank()) continue;

            char dir = line.charAt(0);
            int num = Integer.parseInt(line.substring(1));

            if (dir == 'L') {
                end = start - num;
            } else {
                end = start + num;
            }

            if (end < 0) {
                int loops = end / -100;

                if (start == 0) {
                    solution += loops;
                } else {
                    solution += 1 + loops;
                }

                end = ((end % 100) + 100) % 100;

            } else if (end > 99) {
                solution += end / 100;
                end = end % 100;
            } else if (end == 0) {
                solution += 1;
            }

            start = end;
        }

        return solution;
    }

}
