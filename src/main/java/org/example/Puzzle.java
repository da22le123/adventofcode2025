package org.example;

public abstract class Puzzle {
    protected AocInput aocInput;
    public Puzzle(AocInput input) {
        this.aocInput = input;
    }
    public abstract Object solve();
}
