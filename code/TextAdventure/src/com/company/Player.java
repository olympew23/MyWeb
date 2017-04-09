package com.company;

import java.util.ArrayList;

/**
 * Created by jerieshasmith on 2/8/17.
 */
public class Player extends Character {

    String weapon;
    String location;
    ArrayList<String> items = new ArrayList<>();


        public Player(){
        this.health = 20;
        this.damage = 20;

    }

    public void findItem(String item) {

        System.out.println("You found a "  + item + "! Pick it up? [yes/no]" );

        String answer = Game.nextLine();

        if(answer.equalsIgnoreCase("yes")){
            items.add(item);
            System.out.println("You picked up an item!");
        }
    }






    public void chooseName() {
        System.out.println("What is your name");
        name = Game.nextLine();
        System.out.println("Welcome, " + name);

    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose  your weapon[sword/mace}]");
        weapon = Game.nextLine();


        if (weapon.equalsIgnoreCase("sword")) {
            System.out.println("A sword is a fine choice!");

        } else if (weapon.equalsIgnoreCase("mace")) {
            System.out.println("A mace is a fine choice!");
        } else {
            throw new Exception("Invalid weapon");

        }
    }

    public void chooseLocation() throws Exception {
        System.out.println("Choose your location [forest/tunnel]");
        location = Game.nextLine();

        if (location.equalsIgnoreCase("forest")) {
            System.out.println("Entering forest...");
        } else if (location.equalsIgnoreCase("tunnel")) {
            System.out.println("Entering tunnel...");
        } else {
            throw new Exception("Invalid location.");
        }
    }
}