package org.example.day5;

import org.example.AocInput;
import org.example.Puzzle;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("D")
public class CafeteriaPart2 extends Puzzle {
    public CafeteriaPart2(AocInput input) {
        super(input);
    }

    @Override
    public Object solve() {
        Set<Range> ranges = new HashSet<>();


        // populate
        for (String s : aocInput.lines()) {
            if (s.contains("-")) {
                String[] split = s.split("-");
                long start = Long.parseLong(split[0]);
                long end = Long.parseLong(split[1]);
                ranges.add(new Range(start, end));
            }
        }

        // sort by the start of the ranges
        List<Range> sortedRanges = ranges.stream().sorted(Comparator.comparingLong(r -> r.start)).toList();

        List<Range> result = new ArrayList<>();

        Range current = sortedRanges.get(0);

        for (int i = 1; i < sortedRanges.size(); i++) {
            Range r = sortedRanges.get(i);
            if (current.overlaps(r)) {
                current = mergeRanges(current, r);
            } else {
                result.add(current);
                current = r;
            }
        }
        result.add(current);

        long res = 0;
        for (Range r : result) {
            res += r.end - r.start + 1;
        }

        return res;
    }

    class Range {
        long start;
        long end;


        public Range(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Range other) {
            return this.start <= other.end && other.start <= this.end;
        }

        @Override
        public String toString() {
            return start + "-" + end;
        }
    }

    Range mergeRanges(Range one, Range other) {
        long mergedStart = Math.min(one.start, other.start);
        long mergedEnd = Math.max(one.end, other.end);

        return new Range(mergedStart, mergedEnd);
    }
}
