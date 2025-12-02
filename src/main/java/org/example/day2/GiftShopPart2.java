package org.example.day2;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiftShopPart2 extends Puzzle {
    public GiftShopPart2(AocInput input) {
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
        System.out.println(s);
        List<Integer> divisors = findDivisors(s.length());
        // System.out.println("Divisors " + divisors);

        for (Integer divisor : divisors) {
            List<String> sequences = new ArrayList<>();
            for (int i = 0; i < s.length() / divisor; i++) {
                sequences.add(s.substring(i * divisor, (i + 1) * divisor));
            }

            boolean allSequencesEqual = true;

            for (int i = 1; i < sequences.size(); i++) {
                if (!sequences.get(i).equals(sequences.get(i - 1))) {
                    allSequencesEqual = false;
                }
            }

            if (allSequencesEqual) {
                return true;
            }
        }

        return false;
    }

    List<Integer> findDivisors(long num) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    boolean checkEachCharacter(String s) {
        if (s.length() < 2)
            return false;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1))
                return false;
        }
        return true;
    }
}
