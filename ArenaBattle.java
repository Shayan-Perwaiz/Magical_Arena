package com.magicalarena;

/**
 * ArenaBattle class handles the core battle mechanics
 * Controls the flow of battle between two fighters
 */
public class ArenaBattle {
    private final BattleDice attackDice;
    private final BattleDice defenseDice;
    private final BattleLogger battleLogger;

    public ArenaBattle(BattleDice attackDice, BattleDice defenseDice) {
        this.attackDice = attackDice;
        this.defenseDice = defenseDice;
        this.battleLogger = new BattleLogger();
    }

    /**
     * Conduct a battle between two fighters
     * @return The winning fighter
     */
    public MagicalFighter conductBattle(MagicalFighter fighter1, MagicalFighter fighter2) {
        battleLogger.logBattleStart(fighter1, fighter2);

        // Determine first attacker (lower health attacks first)
        MagicalFighter attacker = determineFirstAttacker(fighter1, fighter2);
        MagicalFighter defender = (attacker == fighter1) ? fighter2 : fighter1;

        int roundNumber = 1;
        
        // Continue battle until one fighter falls
        while (fighter1.isAlive() && fighter2.isAlive()) {
            battleLogger.logRoundStart(roundNumber);
            executeCombatRound(attacker, defender);

            // Swap roles for next round
            MagicalFighter temp = attacker;
            attacker = defender;
            defender = temp;

            roundNumber++;
        }

        MagicalFighter winner = fighter1.isAlive() ? fighter1 : fighter2;
        battleLogger.logBattleEnd(winner);
        return winner;
    }

    /**
     * Determine which fighter attacks first based on life points
     */
    private MagicalFighter determineFirstAttacker(MagicalFighter fighter1, 
                                                MagicalFighter fighter2) {
        return fighter1.getLifePoints() <= fighter2.getLifePoints() ? fighter1 : fighter2;
    }

    /**
     * Execute a single round of combat
     */
    private void executeCombatRound(MagicalFighter attacker, MagicalFighter defender) {
        // Roll dice for attack and defense
        int attackRoll = attackDice.roll();
        int defenseRoll = defenseDice.roll();

        // Calculate damage
        int attackDamage = attacker.calculateAttackDamage(attackRoll);
        int defenseAmount = defender.calculateDefense(defenseRoll);
        int finalDamage = Math.max(0, attackDamage - defenseAmount);

        // Apply damage
        defender.takeDamage(finalDamage);

        // Log results
        battleLogger.logRoundResults(attacker, defender, attackRoll, defenseRoll,
                                   attackDamage, defenseAmount, finalDamage);
    }
}