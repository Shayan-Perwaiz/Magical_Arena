MagicalArena/
├── src/
│   ├── main/java/com/magicalarena/
│   │   ├── MagicalFighter.java
│   │   ├── BattleDice.java
│   │   ├── ArenaBattle.java
│   │   ├── BattleLogger.java
│   │   └── ArenaMain.java
│   └── test/java/com/magicalarena/test/
│       ├── MagicalFighterTest.java
│       ├── BattleDiceTest.java
│       ├── ArenaBattleTest.java
│       ├── BattleLoggerTest.java
│   

Running the Program
Method 1: Using Eclipse

Open ArenaMain.java
Right-click > Run As > Java Application

Game Rules
Fighter Attributes

Health: Life points (must be positive)
Strength: Defense capability
Attack: Attack power

Combat System

Lower health fighter attacks first
Each round:

Attacker rolls dice
Defender rolls dice
Calculate damage: (Attack × Attack Roll) - (Strength × Defense Roll)
Reduce defender's health

Battle continues until one fighter's health reaches 0

Testing
Test Categories

Unit Tests

Fighter attributes and methods
Dice rolling mechanics
Battle calculations


Integration Tests

Complete battle scenarios
Multi-round combat
Edge cases



Running Specific Tests

// Run single test class
Right-click on test file > Run As > JUnit Test

// Run specific test method
Right-click on test method > Run As > JUnit Test

