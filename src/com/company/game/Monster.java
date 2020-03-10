package com.company.game;

import java.util.Random;

public class Monster {
    private static final int monsterMaxHp= 15;
    private static final int monsterMinHp = 5;
    static int hp;
    private static int monsterArmourValue;
    private static int monsterAttackValue;
    private final String name;
    private final String[] monstersNames = {"Skeleton", "Goblin", "ork", "snotling", "zombie", "wolf"};
    Random rand = new Random();

    public Monster() {
        this.name = monstersNames[rand.nextInt(monstersNames.length)];
        this.hp = rand.nextInt((monsterMaxHp-monsterMinHp) +1) + monsterMinHp;
        this.monsterArmourValue = 2;
        this.monsterAttackValue = 2;
    }

    public String getName() {
        return name;
    }

    public static int getMonsterMaxHp() {
        return monsterMaxHp;
    }



    public static int getMonsterHp() {
        return hp;
    }

    public static void setMonsterHp(int monsterHp) {
        Monster.hp=monsterHp;
    }

    public static int getMonsterArmourValue() {
        return monsterArmourValue;
    }

    public static void setMonsterArmourValue(int monsterArmourValue) {
        Monster.monsterArmourValue=monsterArmourValue;
    }

    public static int getMonsterAttackValue() {
        return monsterAttackValue;
    }

    public static void setMonsterAttackValue(int monsterAttackValue) {
        Monster.monsterAttackValue=monsterAttackValue;
    }

    public static void monsterFight () {

    }
}
