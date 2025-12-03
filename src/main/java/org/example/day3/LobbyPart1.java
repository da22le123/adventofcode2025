package org.example.day3;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.Arrays;


public class LobbyPart1 extends Puzzle {
    public LobbyPart1(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        int sum = 0;
        for (String line: aocInput.lines()) {
            int[] batteries = line.chars()
                    .map(c -> c - '0')
                    .toArray();

            int first = 0;
            int second = 0;
            for (int i = 0; i < batteries.length; i++) {
                if (batteries[i] > first && i < batteries.length - 1) {
                    first = batteries[i];
                    second = 0;
                } else if (batteries[i] > second) {
                    second = batteries[i];
                }
            }

            sum += (first*10) + second;
        }
        return sum;
    }
}
