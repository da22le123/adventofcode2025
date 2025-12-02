package org.example.day2;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiftShopPart1 extends Puzzle {
    public GiftShopPart1(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        long res = 0;
        String input = aocInput.lines().getFirst();
        String[] ranges = input.split(",");

        for (String range : ranges) {
            String[] split = range.split("-");

            for (long i = Long.parseLong(split[0]); i <= Long.parseLong(split[1]); i++) {
                String s = String.valueOf(i);

                if (checkInvalid(s)) {
                    res += i;
                }
            }
        }

        return res;
    }

    boolean checkInvalid(String s) {
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);

        return firstHalf.equals(secondHalf);
    }
}
