package levels;

import characters.Wizard;
import creatures.PeterPettigrew;
import creatures.Voldemort;
import items.MajorHealingPotion;
import input.InputSource;

public class Level4 extends Level {

    public Level4() {
        super("Niveau 4");
    }

    @Override
    public boolean startLevel(Wizard wizard, InputSource inputSource) {
        System.out.println("Bienvenue dans le niveau 4 !");
        System.out.println("Vous êtes au Cimetière de Little Hangleton et vous allez affronter Voldemort et Peter Pettigrew.");

        Voldemort voldemort = new Voldemort("Voldemort", 150, 35);
        PeterPettigrew peterPettigrew = new PeterPettigrew("Peter Pettigrew", 100, 20);
        MajorHealingPotion majorHealingPotion = new MajorHealingPotion();
        wizard.addToInventory(majorHealingPotion);
        boolean playerTurn = true;

        while (wizard.getHealthPoints() > 0 && (voldemort.getHealthPoints() > 0 || peterPettigrew.getHealthPoints() > 0)) {
            System.out.println("\nPoints de vie du sorcier : " + wizard.getHealthPoints());
            System.out.println("Points de vie de Voldemort : " + voldemort.getHealthPoints());
            System.out.println("Points de vie de Peter Pettigrew : " + peterPettigrew.getHealthPoints());

            if (playerTurn) {
                System.out.println("\nC'est votre tour. Que voulez-vous faire ?");
                System.out.println("1. Attaquer Voldemort");
                System.out.println("2. Attaquer Peter Pettigrew");
                System.out.println("3. Utiliser une potion de soin");

                int choice = Integer.parseInt(inputSource.getInput());

                if (choice == 1) {
                    wizard.attack(voldemort);
                    System.out.println("Vous attaquez Voldemort !");
                } else if (choice == 2) {
                    wizard.attack(peterPettigrew);
                    System.out.println("Vous attaquez Peter Pettigrew !");
                } else if (choice == 3) {
                    wizard.displayInventory();
                    System.out.println("Entrez l'index de l'objet à utiliser (1 pour le premier, etc.) : ");
                    int itemIndex = Integer.parseInt(inputSource.getInput()) - 1;
                    wizard.useHealingItem(itemIndex);
                    System.out.println("Vous utilisez une potion de soin !");
                } else {
                    System.out.println("Choix invalide. Vous ne faites rien.");
                }
            } else {
                if (voldemort.getHealthPoints() > 0) {
                    voldemort.attack(wizard);
                    System.out.println("Voldemort vous attaque !");
                }
                if (peterPettigrew.getHealthPoints() > 0) {
                    peterPettigrew.attack(wizard);
                    System.out.println("Peter Pettigrew vous attaque !");
                }
            }

            playerTurn = !playerTurn;
        }

        if (wizard.getHealthPoints() > 0) {
            System.out.println("Félicitations ! Vous avez vaincu Voldemort et Peter Pettigrew !");
            wizard.addToInventory(new MajorHealingPotion());
            System.out.println("Vous avez obtenu une potion de soin majeure !");
            return true;
        } else {
            System.out.println("Vous avez été vaincu par Voldemort et Peter Pettigrew.");
            return false;
        }}}