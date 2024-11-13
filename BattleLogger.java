package com.magicalarena;

/**
 * BattleLogger handles all the output formatting and logging
 * for the battle sequence
 */
public class BattleLogger {
    
    /**
     * Log the start of a battle
     */
    public void logBattleStart(MagicalFighter fighter1, MagicalFighter fighter2) {
        System.out.println("=== BATTLE BEGINS ===");
        System.out.println("First Fighter: " + fighter1);
        System.out.println("Second Fighter: " + fighter2);
        System.out.println();
    }

    /**
     * Log the start of each round
     */
    public void logRoundStart(int roundNumber) {
        System.out.println("Round " + roundNumber + ":");
    }

    /**
     * Log the results of each round
     */
    public void logRoundResults(MagicalFighter attacker, MagicalFighter defender,
                              int attackRoll, int defenseRoll,
                              int attackDamage, int defenseAmount,
                              int finalDamage) {
                                  
        System.out.printf("%s attacks %s%n", 
            attacker.getFighterName(), defender.getFighterName());
        System.out.printf("Attack Roll: %d, Defense Roll: %d%n", 
            attackRoll, defenseRoll);
        System.out.printf("Attack Damage: %d, Defense Amount: %d%n", 
            attackDamage, defenseAmount);
        System.out.printf("Final Damage Dealt: %d%n", finalDamage);
        System.out.printf("%s's remaining life: %d%n%n", 
            defender.getFighterName(), defender.getLifePoints());
    }

    /**
     * Log the end of battle
     */
    public void logBattleEnd(MagicalFighter winner) {
        System.out.println("=== BATTLE ENDED ===");
        System.out.println("Victory: " + winner.getFighterName());
        System.out.println("Remaining Life Points: " + winner.getLifePoints());
    }
}