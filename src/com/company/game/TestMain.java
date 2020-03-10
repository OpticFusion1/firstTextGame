package com.company.game;

import java.util.Random;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Player player1=new Player("Pioter");
        player1.bagPack.add("magical necklace");


        Scanner in=new Scanner(System.in);
        Random rand=new Random();

        Monster monster=new Monster();
        System.out.println(monster.getName() + " appeared!");
// Fighting code execution
        FIGHT:
        while (monster.getMonsterHp() > 0) {
            System.out.println("\tYour hp: " + player1.getHp());
            System.out.println("\t" + monster.getName() + "'s hp: " + monster.getMonsterHp());
            System.out.println("\n\tWhat would like to do?");
            System.out.println("\t1.Attack \n\t2.drink health potion\n\t3.run!");

            String input=in.nextLine();
            if (input.equals("1")) {
                int dmgDealt=player1.getAttackValue();
                int dmgTaken=monster.getMonsterAttackValue();
                player1.hp=player1.hp - dmgTaken;
                monster.hp=monster.hp - dmgDealt;

                System.out.println("\t> You strike the " + monster.getName() + " for " + dmgDealt);
                System.out.println("\t> You receive " + dmgTaken + " wounds");

                if (player1.hp < 1) {
                    System.out.println("\tYou died!");
                    break;
                }
            } else if (input.equals("2")) {
                if (player1.numHealthPotions > 0) {
                    player1.hp+=player1.healthPotionHealAmount;
                    if (player1.hp > player1.getMaxHp()) {
                        player1.hp=player1.getMaxHp();
                    }
                    player1.numHealthPotions--;
                    System.out.println("\t> You drink a health potion, you healed: " + player1.healthPotionHealAmount + " wounds");
                    System.out.println("\t> You know have: " + player1.hp + " hit points");
                    System.out.println("\t> You know habe " + player1.numHealthPotions + " potions left");

                } else {
                    System.out.println("You have no health potions.");
                }
            } else if (input.equals("3")) {
                System.out.println("You run away from " + monster.getName() + "!");
                break;
            } else {
                System.out.println("\tinvalid command.");
            }
        }
        while (player1.hp < 1) {
            System.out.println("game over");
            break;
        }

            if(monster.getMonsterHp() < 1 ) {
                System.out.println("------------------------------------------");
                System.out.println("\t" + monster.getName() + " was defeated");
                System.out.println("\t You have " + player1.getHp() + " hit points left");
                if (rand.nextInt(100) < player1.healthPotionDropChance) {
                    player1.numHealthPotions++;
                    System.out.println("\t The enemy dropped a health potion");
                    System.out.println("\t You have now " + player1.numHealthPotions + " left");
                }

            }
        }
    }

