package com.heavyweightsoftware;

import java.util.Random;

public class Die6 {
    public static final Random random = new Random();

    private int value;

    public Die6() {
        roll();
    }

    public int getValue() {
        return value;
    }

    public int roll() {
        value = random.nextInt(6) + 1;
        return getValue();
    }

    public static void rollDice(Die6[] dice) {
        for (Die6 die : dice) {
            die.roll();
        }
    }
}
