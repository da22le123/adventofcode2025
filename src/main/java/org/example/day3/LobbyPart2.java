package org.example.day3;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.Arrays;
import java.util.stream.IntStream;

@SuppressWarnings("D")
public class LobbyPart2 extends Puzzle {
    public LobbyPart2(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        long sum = 0;
        for (String line: aocInput.lines()) {
            long[] batteries = line.chars()
                    .mapToLong(c -> c - '0')
                    .toArray();

            long[] batteriesOn = new long[12];
            for (int i = 0; i < batteries.length; i++) {
                for (int j = 0; j < batteriesOn.length; j++) {
                    if (batteries[i] > batteriesOn[j] && batteries.length - i >= batteriesOn.length - j) {
                        batteriesOn[j] = batteries[i];
                        batteriesOn = resetAllAfter(batteriesOn, j);
                        break;
                    }
                }
            }

            sum += Arrays.stream(batteriesOn).reduce(0, (subtotal, element) -> subtotal *10 + element);
        }
        return sum;
    }

    /**
     * resets all to 0 after given index
     * so for input (int{5,9,3}, 1)
     * output is {5,0,0}
     *
     */
    long[] resetAllAfter(long[] original, int index) {
        long[] res = new long[original.length];

        for (int i = 0; i < res.length; i++) {
            if (i <= index) {
                res[i] = original[i];
            } else {
                res[i] = 0;
            }
        }

        return res;
    }
}
