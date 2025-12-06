package org.example.day5;

import org.example.AocInput;
import org.example.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class CafeteriaPart1 extends Puzzle {
    public CafeteriaPart1(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        int res = 0;

        List<List<Long>> ranges = new ArrayList<>();
        List<Long> ids = new ArrayList<>();

        for (String s : aocInput.lines()) {
            if (s.contains("-")) {
                String[] split = s.split("-");
                long start = Long.parseLong(split[0]);
                long end = Long.parseLong(split[1]);
                ranges.add(new ArrayList<>(List.of(start, end)));
            } else if (!s.isBlank()){
                ids.add(Long.parseLong(s));
            }
        }

        System.out.println(ranges.size());

        for (Long id : ids) {
            System.out.println(id);
            for (List<Long> range : ranges) {
                if (id >= range.getFirst() && id <= range.getLast()) {
                    res ++;
                    break;
                }
            }
        }

        return res;
    }
}

//  711 > x < 835