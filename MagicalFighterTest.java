package com.magicalarena.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.magicalarena.MagicalFighter;

public class MagicalFighterTest {
    private MagicalFighter fighter;

    @BeforeEach
    void setUp() {
        // Create new fighter before each test
        fighter = new MagicalFighter("TestFighter", 100, 10, 15);
    }

    @Test
    void testFighterCreation() {
        assertEquals("TestFighter", fighter.getFighterName());
        assertEquals(100, fighter.getLifePoints());
        assertEquals(10, fighter.getDefenseRating());
        assertEquals(15, fighter.getAttackPower());
    }

    @Test
    void testInvalidHealthCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MagicalFighter("TestFighter", 0, 10, 15);
        });
    }

    @Test
    void testInvalidStrengthCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MagicalFighter("TestFighter", 100, 0, 15);
        });
    }

    @Test
    void testInvalidAttackCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MagicalFighter("TestFighter", 100, 10, 0);
        });
    }

    @Test
    void testCalculateAttackDamage() {
        assertEquals(30, fighter.calculateAttackDamage(2)); // 15 * 2
        assertEquals(75, fighter.calculateAttackDamage(5)); // 15 * 5
    }

    @Test
    void testCalculateDefense() {
        assertEquals(20, fighter.calculateDefense(2)); // 10 * 2
        assertEquals(50, fighter.calculateDefense(5)); // 10 * 5
    }

    @Test
    void testTakeDamage() {
        fighter.takeDamage(30);
        assertEquals(70, fighter.getLifePoints());
    }

    @Test
    void testTakeDamageNotBelowZero() {
        fighter.takeDamage(150); // More than current health
        assertEquals(0, fighter.getLifePoints());
    }

    @Test
    void testIsAlive() {
        assertTrue(fighter.isAlive());
        fighter.takeDamage(100);
        assertFalse(fighter.isAlive());
    }

    @Test
    void testToString() {
        String expected = "TestFighter [health: 100, strength: 10, attack: 15]";
        assertEquals(expected, fighter.toString());
    }
}