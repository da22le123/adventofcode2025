package org.example;

import org.example.day1.SecretEntrancePart1;
import org.example.day1.SecretEntrancePart2;
import org.example.day2.GiftShopPart1;
import org.example.day3.LobbyPart1;
import org.example.day3.LobbyPart2;

public class Main {
    public static void main(String[] args) {
        AocInput aocInput = AocInput.read();
        LobbyPart2 lobbyPart2 = new LobbyPart2(aocInput);
        if (lobbyPart2.solve() instanceof Long res) {
            System.out.println(res);
        } else {
            System.err.println("didn't return an integer");
        }
    }
}

// 170106412156353 too high