package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class AocInput implements Iterable<String> {
    private final List<String> lines;

    private AocInput(List<String> lines) {
        this.lines = lines;
    }

    /**
     * Reads input from stdin until EOF (Ctrl+D on Unix, Ctrl+Z on Windows)
     * or an empty line.
     */
    public static AocInput read() {
        System.out.println("Paste your input (end with Ctrl+D or empty line):");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("end")) break; // Empty line ends input
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input", e);
        }

        return new AocInput(lines);
    }

    /**
     * Creates input from a string (useful for testing).
     */
    public static AocInput of(String input) {
        return new AocInput(Arrays.asList(input.split("\n")));
    }

    // === Basic accessors ===

    public List<String> lines() {
        return new ArrayList<>(lines);
    }

    public Stream<String> stream() {
        return lines.stream();
    }

    public String raw() {
        return String.join("\n", lines);
    }

    public int size() {
        return lines.size();
    }

    public String line(int index) {
        return lines.get(index);
    }

    // === Parsing helpers ===

    public List<Integer> asInts() {
        return lines.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public List<Long> asLongs() {
        return lines.stream()
                .map(Long::parseLong)
                .toList();
    }

    public <T> List<T> map(Function<String, T> mapper) {
        return lines.stream()
                .map(mapper)
                .toList();
    }

    /**
     * Splits each line by delimiter.
     * Useful for CSV-like inputs.
     */
    public List<String[]> splitLines(String delimiter) {
        return lines.stream()
                .map(line -> line.split(delimiter))
                .toList();
    }

    /**
     * Treats entire input as single-line, comma/delimiter separated values.
     * Useful for inputs like "1,2,3,4,5" or "R8,U5,L5,D3"
     */
    public List<String> splitSingle(String delimiter) {
        return Arrays.asList(raw().split(delimiter));
    }

    /**
     * For grid-based puzzles - returns char matrix.
     */
    public char[][] asGrid() {
        return lines.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }

    /**
     * Groups lines separated by blank lines.
     * Useful for puzzles with paragraph-separated data.
     */
    public List<List<String>> groups() {
        List<List<String>> groups = new ArrayList<>();
        List<String> current = new ArrayList<>();

        for (String line : lines) {
            if (line.isBlank()) {
                if (!current.isEmpty()) {
                    groups.add(current);
                    current = new ArrayList<>();
                }
            } else {
                current.add(line);
            }
        }
        if (!current.isEmpty()) {
            groups.add(current);
        }
        return groups;
    }

    @Override
    public Iterator<String> iterator() {
        return lines.iterator();
    }
}