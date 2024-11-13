package com.magicalarena;

/**
 * Main class to run the Magical Arena battle game
 */
public class ArenaMain {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Magical Arena!\n");

            MagicalFighter fighterA = new MagicalFighter("Fighter A", 50, 5, 10);

            MagicalFighter fighterB = new MagicalFighter("Fighter B", 100, 10, 5);

            // Show initial stats
            System.out.println("Initial Fighter Statistics:");
            System.out.println(fighterA);
            System.out.println(fighterB);
            System.out.println();

            // Create 6-sided dice for attack and defense
            BattleDice attackDice = new BattleDice(6);
            BattleDice defenseDice = new BattleDice(6);

            // Create arena and start battle
            ArenaBattle arena = new ArenaBattle(attackDice, defenseDice);
            
            // Conduct battle and get winner
            MagicalFighter winner = arena.conductBattle(fighterA, fighterB);

            // Display final status
            System.out.println("\nFinal Battle Result:");
            System.out.println("Winner: " + winner.getFighterName());
            System.out.println("Remaining Life Points: " + winner.getLifePoints());

        } catch (IllegalArgumentException e) {
            System.err.println("Error in battle setup: " + e.getMessage());
        }
    }
}