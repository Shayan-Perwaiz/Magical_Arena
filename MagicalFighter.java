package com.magicalarena;

/**
 * MagicalFighter class represents a fighter in the arena
 * Each fighter has health, strength and attack attributes
 */
public class MagicalFighter {
    private final String fighterName;
    private int health;          // Health points of the fighter
    private final int strength; // Strength attribute for defense
    private final int attack;   // Attack attribute for damage

    /**
     * Constructor to create a new fighter
     * @param fighterName Name of the fighter
     * @param lifePoints Initial health points
     * @param defenseRating Defense/Strength value
     * @param attackPower Attack power value
     */
    public MagicalFighter(String fighterName, int health, int strength, int attack) {
        validateStats(health, strength, attack);
        this.fighterName = fighterName;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    /**
     * Validates that all fighter stats are positive
     */
    private void validateStats(int health, int strength, int attack) {
        if (health <= 0) {
            throw new IllegalArgumentException("Life points must be positive");
        }
        if (strength <= 0) {
            throw new IllegalArgumentException("Defense rating must be positive");
        }
        if (attack <= 0) {
            throw new IllegalArgumentException("Attack power must be positive");
        }
    }

    /**
     * Calculate total attack damage based on dice roll
     */
    public int calculateAttackDamage(int diceValue) {
        return attack * diceValue;
    }

    /**
     * Calculate total defense based on dice roll
     */
    public int calculateDefense(int diceValue) {
        return strength * diceValue;
    }

    /**
     * Reduce fighter's life points by damage amount
     */
    public void takeDamage(int damageAmount) {
        this.health = Math.max(0, this.health - damageAmount);
    }

    /**
     * Check if fighter is still alive
     */
    public boolean isAlive() {
        return health > 0;
    }

    // Getters
    public String getFighterName() {
        return fighterName;
    }

    public int getLifePoints() {
        return health;
    }

    public int getDefenseRating() {
        return strength;
    }

    public int getAttackPower() {
        return attack;
    }

    @Override
    public String toString() {
        return String.format("%s [health: %d, strength: %d, attack: %d]",
            fighterName, health, strength, attack);
    }
}