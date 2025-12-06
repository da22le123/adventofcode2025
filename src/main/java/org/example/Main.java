package org.example;

import org.example.day1.SecretEntrancePart1;
import org.example.day1.SecretEntrancePart2;
import org.example.day2.GiftShopPart1;
import org.example.day3.LobbyPart1;
import org.example.day3.LobbyPart2;
import org.example.day4.PrintingDepartmentPart1;
import org.example.day4.PrintingDepartmentPart2;
import org.example.day5.CafeteriaPart1;
import org.example.day5.CafeteriaPart2;

public class Main {
    public static void main(String[] args) {
        AocInput aocInput = AocInput.read();
        Puzzle puzzle = new CafeteriaPart2(aocInput);
        if (puzzle.solve() instanceof Long res) {
            System.out.println(res);
        } else {
            System.err.println("didn't return an integer");
        }
    }
}

// 170106412156353 too high