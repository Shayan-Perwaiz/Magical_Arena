package com.magicalarena;

import java.util.Random;

/**
 * BattleDice class handles the dice rolling mechanics for the game
 * Generates random numbers between 1 and the number of sides
 */
public class BattleDice {
    private final int sides;
    private final Random randomGenerator;

    /**
     * Constructor to create a dice with specified number of sides
     * @param sides Number of sides on the dice
     */
    public BattleDice(int sides) {
        if (sides < 1) {
            throw new IllegalArgumentException("Dice must have at least one side");
        }
        this.sides = sides;
        this.randomGenerator = new Random();
    }

    /**
     * Roll the dice and get a random number
     * @return Random number between 1 and number of sides
     */
    public int roll() {
        return randomGenerator.nextInt(sides) + 1;
    }

    /**
     * Get the number of sides on this dice
     */
    public int getSides() {
        return sides;
    }
}