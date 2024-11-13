package com.magicalarena.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.magicalarena.BattleDice;

public class BattleDiceTest {

    @Test
    void testDiceCreation() {
        BattleDice dice = new BattleDice(6);
        assertEquals(6, dice.getSides());
    }

    @Test
    void testInvalidDiceCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BattleDice(0);
        });
    }

    @Test
    void testRollRange() {
        BattleDice dice = new BattleDice(6);
        for (int i = 0; i < 100; i++) { // Test multiple rolls
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    void testDifferentSizedDice() {
        BattleDice d4 = new BattleDice(4);
        BattleDice d8 = new BattleDice(8);

        for (int i = 0; i < 50; i++) {
            assertTrue(d4.roll() >= 1 && d4.roll() <= 4);
            assertTrue(d8.roll() >= 1 && d8.roll() <= 8);
        }
    }
}