package com.company.game;


public class Player extends Inventory {
    private static int maxHp;
    static int hp;
    private static int armourValue;
    private static int attackValue;
    private String name;

    public int getMaxHp() {
        return maxHp;
    }

    public static void setMaxHp(int maxHp) { Player.maxHp=maxHp; }

    public int getHp() { return hp; }

    public static void setHp(int hp) { Player.hp=hp; }

    public String getName() { return name; }

    public static int getArmourValue() { return armourValue; }

    public static int setArmourValue() { return Player.armourValue = changeArmourValue();    }

    public static int getAttackValue() { return attackValue; }

    public static int setAttackValue() { return Player.attackValue = changeAttackValue(); }

    public Player(String name) {
        this.hp = 20;
        this.maxHp = 20;
        this.name=name;
        new Inventory();
        armourValue=setArmourValue();
        attackValue= 2 + setAttackValue();
        this.numHealthPotions = 1;
        this.healthPotionDropChance = 33;
        this.healthPotionHealAmount = 10;

    }



}

