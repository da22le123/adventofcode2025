package org.example;

import org.example.day1.SecretEntrancePart1;
import org.example.day1.SecretEntrancePart2;
import org.example.day2.GiftShopPart1;

public class Main {
    public static void main(String[] args) {
        AocInput aocInput = AocInput.read();
        GiftShopPart1 giftShopPart1 = new GiftShopPart1(aocInput);
        if (giftShopPart1.solve() instanceof Long res) {
            System.out.println(res);
        } else {
            System.err.println("didn't return an integer");
        }
    }
}