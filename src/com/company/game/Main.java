package com.company.game;



import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations=new HashMap<>();

    public static void main(String[] args) {

        Random rand=new Random();
        Scanner scanner=new Scanner(System.in);
        // first message.
        System.out.println("****************************************************");
        System.out.println("This is the begging of a game, and here are some hints :" +
                "\nto move around the map type were you wanna go( if you want to quit type quit(or 'Q') " +
                "\nthe rest you will have to figure out");
        System.out.println("****************************************************\n");
        // creating a player

        System.out.println("Enter your name :");
        Player player1;
        player1=new Player(scanner.nextLine());
        System.out.println("****************************************************\n");
        System.out.println("Your name is " + player1.getName() + ". You wield a " + player1.getWeapon()
        + ", and you wear a " + player1.getArmour() + ". \nyour attack power is: " + Player.getAttackValue()
        + "\nyour defence is: " + Player.getArmourValue() + "\nyou have: " + player1.getHp() + " hit points");
        System.out.println("****************************************************\n");

        // creating a map
        Map<String , Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "-=- Thanks for playing -=-",tempExit));

        tempExit =  new HashMap<>();
        tempExit.put("E", 2);


        locations.put(1, new Location(1, "You are standing on way from a burnt down village, " +
                "there is only one way to go...",tempExit));

        tempExit =  new HashMap<>();
        tempExit.put("E", 3);
        locations.put(2, new Location(2, "You wander through the road, wandering about your life, " +
                "and what to do next...",tempExit));

        tempExit =  new HashMap<>();
        tempExit.put("E", 4);
        locations.put(3, new Location(3, "The sun is getting down while you travel, and you " +
                "feel that something is't right...",tempExit));

        tempExit =  new HashMap<>();
        tempExit.put("E", 5);
        locations.put(4, new Location(4, "You find a destroyed carriage, abandoned, yet your hear " +
                "some strange noises nearby... ",tempExit));
        

                Monster monster=new Monster();
                System.out.println(monster.getName() + " appeared!");
// Fighting code execution
                FIGHT:
                while (monster.getMonsterHp() > 0) {
                    System.out.println("------------------------------------------");
                    System.out.println("\tYour hp: " + player1.getHp());
                    System.out.println("\t" + monster.getName() + "'s hp: " + monster.getMonsterHp());
                    System.out.println("\n\tWhat would like to do?");
                    System.out.println("\t1.Attack \n\t2.drink health potion\n\t3.run!");

                    String input=scanner.nextLine();
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
                            Player.hp+=player1.healthPotionHealAmount;
                            if (Player.hp > player1.getMaxHp()) {
                                Player.hp=player1.getMaxHp();
                            }
                            player1.numHealthPotions--;
                            System.out.println("\t> You drink a health potion, you healed: " + player1.healthPotionHealAmount + " wounds");
                            System.out.println("\t> You know have: " + Player.hp + " hit points");
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
                if (Player.hp < 1) {
                    System.out.println("game over");

                }

                if (Monster.getMonsterHp() < 1) {
                    System.out.println("------------------------------------------");
                    System.out.println("\t " + monster.getName() + " was defeated");
                    System.out.println("\t You have " + player1.getHp() + " hit points left");
                    System.out.println("------------------------------------------");
                    if (rand.nextInt(100) < player1.healthPotionDropChance) {
                        player1.numHealthPotions++;
                        System.out.println("\t The enemy dropped a health potion");
                        System.out.println("\t You have now " + player1.numHealthPotions + " left");
                    } else {
                        System.out.println("You moved ahead");

                    }

                }


        tempExit =  new HashMap<>();
        locations.put(5, new Location(5, "You are in the forest",tempExit));

        Map<String ,String > vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("East", "E");


        int loc=1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits=locations.get(loc).getExits();
            System.out.println("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction=scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc=exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }


        }
    }
}
