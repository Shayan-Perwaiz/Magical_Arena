package com.magicalarena.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.magicalarena.BattleLogger;
import com.magicalarena.MagicalFighter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BattleLoggerTest {
    private BattleLogger logger;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    private MagicalFighter fighter1;
    private MagicalFighter fighter2;

    @BeforeEach
    void setUp() {
        logger = new BattleLogger();
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        fighter1 = new MagicalFighter("Fighter1", 100, 10, 15);
        fighter2 = new MagicalFighter("Fighter2", 80, 8, 12);
    }

    @Test
    void testLogBattleStart() {
        logger.logBattleStart(fighter1, fighter2);
        String output = outputStream.toString();
        
        assertTrue(output.contains("BATTLE BEGINS"));
        assertTrue(output.contains(fighter1.toString()));
        assertTrue(output.contains(fighter2.toString()));
    }

    @Test
    void testLogRoundStart() {
        logger.logRoundStart(1);
        assertTrue(outputStream.toString().contains("Round 1"));
    }

    @Test
    void testLogRoundResults() {
        logger.logRoundResults(fighter1, fighter2, 4, 3, 60, 24, 36);
        String output = outputStream.toString();
        
        assertTrue(output.contains("Fighter1 attacks Fighter2"));
        assertTrue(output.contains("Attack Roll: 4"));
        assertTrue(output.contains("Defense Roll: 3"));
        assertTrue(output.contains("Attack Damage: 60"));
        assertTrue(output.contains("Defense Amount: 24"));
        assertTrue(output.contains("Final Damage Dealt: 36"));
    }

    @Test
    void testLogBattleEnd() {
        logger.logBattleEnd(fighter1);
        String output = outputStream.toString();
        
        assertTrue(output.contains("BATTLE ENDED"));
        assertTrue(output.contains(fighter1.getFighterName()));
    }
}