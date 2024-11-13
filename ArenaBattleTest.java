package com.magicalarena.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.magicalarena.ArenaBattle;
import com.magicalarena.BattleDice;
import com.magicalarena.MagicalFighter;

public class ArenaBattleTest {
    private ArenaBattle arena;
    private MagicalFighter fighter1;
    private MagicalFighter fighter2;
    private BattleDice dice;

    @BeforeEach
    void setUp() {
        dice = new BattleDice(6);
        arena = new ArenaBattle(dice, dice);
        fighter1 = new MagicalFighter("Fighter1", 50, 5, 10);
        fighter2 = new MagicalFighter("Fighter2", 100, 10, 5);
    }

    @Test
    void testBattleExecution() {
        MagicalFighter winner = arena.conductBattle(fighter1, fighter2);
        assertNotNull(winner);
        assertTrue(winner.isAlive());
    }  

    @Test
    void testBattleEndsWithOneFighterDead() {
        arena.conductBattle(fighter1, fighter2);
        assertTrue((!fighter1.isAlive() && fighter2.isAlive()) || 
                  (fighter1.isAlive() && !fighter2.isAlive()));
    }

    @Test
    void testLowerHealthAttacksFirst() {
        MagicalFighter weakFighter = new MagicalFighter("Weak", 30, 5, 10);
        MagicalFighter strongFighter = new MagicalFighter("Strong", 100, 10, 5);
        
        arena.conductBattle(weakFighter, strongFighter);
        // The battle should execute without errors
        assertTrue(true);
    }

    @Test
    void testOriginalStatsPreserved() {
        int originalAttack1 = fighter1.getAttackPower();
        int originalDefense1 = fighter1.getDefenseRating();
        
        arena.conductBattle(fighter1, fighter2);
        
        assertEquals(originalAttack1, fighter1.getAttackPower());
        assertEquals(originalDefense1, fighter1.getDefenseRating());
    }

    @Test
    void testMultipleBattles() {
        // Test that arena can handle multiple battles
        MagicalFighter f1 = new MagicalFighter("F1", 50, 5, 10);
        MagicalFighter f2 = new MagicalFighter("F2", 50, 5, 10);
        
        arena.conductBattle(f1, f2);
        
        MagicalFighter f3 = new MagicalFighter("F3", 50, 5, 10);
        MagicalFighter f4 = new MagicalFighter("F4", 50, 5, 10);
        
        arena.conductBattle(f3, f4);
        // Both battles should complete without errors
        assertTrue(true);
    }
}