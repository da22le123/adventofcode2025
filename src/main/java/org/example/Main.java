package org.example;

import org.example.day1.SecretEntrancePart1;
import org.example.day1.SecretEntrancePart2;

public class Main {
    public static void main(String[] args) {
        AocInput aocInput = AocInput.read();
        SecretEntrancePart1 secretEntrance = new SecretEntrancePart1(aocInput);
        if (secretEntrance.solve() instanceof Integer res) {
            System.out.println(res);
        } else {
            System.err.println("didn't return an integer");
        }
    }
}