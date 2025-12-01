package org.example;

import org.example.day1.SecretEntrance;

public class Main {
    public static void main(String[] args) {
        AocInput aocInput = AocInput.read();
        SecretEntrance secretEntrance = new SecretEntrance(aocInput);
        if (secretEntrance.solve() instanceof Integer res) {
            System.out.println(res);
        } else {
            System.err.println("didn't return an integer");
        }
    }
}