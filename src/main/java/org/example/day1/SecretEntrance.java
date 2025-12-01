package org.example.day1;

import org.example.AocInput;
import org.example.Puzzle;

public class SecretEntrance extends Puzzle {
    public SecretEntrance(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        int counter = 0;
        int dial = 50;

        for (String line: aocInput.lines()) {
            if (line.isBlank()) {
                continue;
            }

            char direction = line.charAt(0);
            int rotation = Integer.parseInt(line.substring(1));

            if (direction == 'L') {
                dial = dial - rotation;
            } else if (direction == 'R'){
                dial = dial + rotation;
            } else {
                throw new IllegalStateException("Illegal direction: " + direction);
            }

            dial = normalize(dial);
            if (dial == 0) {
                counter++;
            }
        }

        return counter;
    }

    public int normalize(int dial) {
        int multiplier = Math.abs(dial>=100 || dial<=-100 ? dial / 100 : 1);
        if (dial < 0) {
            return multiplier* 100 - ( -dial);
        } else if (dial > 99) {
            return dial - 100 * multiplier;
        } else {
            return dial;
        }
    }
}
