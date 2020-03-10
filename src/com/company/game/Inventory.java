package com.company.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Inventory {
    private static String weapon;
    private static String armour;
    ArrayList bagPack;
    static final List<String> weaponList=Arrays.asList("knife", "sword", "great sword", "great axe", "axe", "flail", "spear", "pointed stick");
    static final List<String> armourList=Arrays.asList("chain mail", "scale mail", "leather armour", "plate mail","robe");
    int numHealthPotions;
    int healthPotionHealAmount;
    int healthPotionDropChance;

    public Inventory() {
        this.weapon = getRandomElement(weaponList);
        this.armour = getRandomElement(armourList);
        this.bagPack=new ArrayList<String>();

    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon=weapon;
    }

    public String getArmour() {
        return armour;
    }

    public void setArmour(String armour) {
        this.armour=armour;
    }

// Simple random engine for multi-purpose.
    public String getRandomElement(List<String> random)    {
        int rand = (int) ( Math.random() * random.size());
        return random.get(rand);
    }
// Changing attack value based on weapon equipped.
    public static int changeAttackValue() {
        if (weapon == weaponList.get(0)) {
            return 2;
        } else if (weapon == weaponList.get(1)) {
           return 4;
        } else if ((weapon == weaponList.get(2)) || (weapon == weaponList.get(3))) {
            return 6;
        } else if ((weapon == weaponList.get(4)) || (weapon == weaponList.get(5))) {
            return 3;
        } else if (weapon == weaponList.get(6)) {
            return 5;
        } else if (weapon == weaponList.get(7)) {
            return 1;
        }
        return 0;
    }
// Changing armour value based on armour equipped.
    public static int changeArmourValue() {
        if ((armour == armourList.get(0)) || (armour == armourList.get(1))) {
            return 4;
        } else if (armour == armourList.get(2)) {
            return 2;
        } else if (armour == armourList.get(3)) {
            return 6;
                   } else if (armour == armourList.get(4)) {
            return 0;
        }
       return 0;
    }
// Changing hit points based on items in bag pack.
    public void changeHpValue() {
        if (bagPack.contains("magical necklace")) {
            Player.setMaxHp(15);
        }

    }
}
