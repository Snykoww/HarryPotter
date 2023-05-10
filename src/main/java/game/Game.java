package game;

import characters.Wizard;
import houses.House;
import items.HealingItem;
import levels.*;
import input.InputSource;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Wizard player;
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;
    private Level5 level5;
    private Level6 level6;
    private Level7 level7;
    private InputSource inputSource;

    public Game(InputSource inputSource) {
        this.inputSource = inputSource;

        // Initialization of levels
        level1 = new Level1();
        level2 = new Level2();
        level3 = new Level3();
        level5 = new Level5();
        level6 = new Level6();
        level7 = new Level7();

        // Generate a random house for the wizard
        Random random = new Random();
        House randomHouse = House.values()[random.nextInt(House.values().length)];

        // Start the game
        player = new Wizard("Player", 500, 80,randomHouse);
        System.out.println("Votre sorcier a été assigné à la maison " + player.getHouse() + "!");

        // Creation of healing items
        HealingItem potion1 = new HealingItem("Potion de vie mineure", 100);
        HealingItem potion2 = new HealingItem("Potion de vie majeure", 150);

        // Add healing items to the player's inventory
        player.addToInventory(potion1);
        player.addToInventory(potion2);
    }

    public void start() {
        if (player.getHealthPoints() > 0) {
            level1.startLevel(player, inputSource);
        }

        if (player.getHealthPoints() > 0) {
            level2.startLevel(player, inputSource);
        }
        if (player.getHealthPoints() > 0) {
            level3.startLevel(player, inputSource);
        }

        if (player.getHealthPoints() > 0) {
            level5.startLevel(player, inputSource);
        }

        if (player.getHealthPoints() > 0) {
            level6.startLevel(player, inputSource);
        }

        if (player.getHealthPoints() > 0) {
            level7.startLevel(player, inputSource);
        }

        System.out.println("Fin du jeu. Merci d'avoir joué !");
    }

    public void stop() {
        // Add code here to stop the game
    }
}