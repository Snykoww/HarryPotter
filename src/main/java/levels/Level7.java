package levels;

import characters.Wizard;
import creatures.BellatrixLestrange;
import creatures.Voldemort;
import items.MajorHealingPotion;
import input.InputSource;

public class Level7 extends Level {

    public Level7() {
        super("Niveau 7");
    }

    @Override
    public boolean startLevel(Wizard wizard, InputSource inputSource) {
        System.out.println("Bienvenue dans le niveau 7 !");
        System.out.println("Vous êtes à Poudlard et vous allez affronter Voldemort et Bellatrix Lestrange.");

        Voldemort voldemort = new Voldemort("Voldemort", 200, 40);
        BellatrixLestrange bellatrix = new BellatrixLestrange("Bellatrix Lestrange", 150, 30);
        boolean playerTurn = true;

        while (wizard.getHealthPoints() > 0 && (voldemort.getHealthPoints() > 0 || bellatrix.getHealthPoints() > 0)) {
            System.out.println("\nPoints de vie du sorcier : " + wizard.getHealthPoints());
            System.out.println("Points de vie de Voldemort : " + voldemort.getHealthPoints());
            System.out.println("Points de vie de Bellatrix Lestrange : " + bellatrix.getHealthPoints());

            if (playerTurn) {
                System.out.println("\nC'est votre tour. Que voulez-vous faire ?");
                System.out.println("1. Attaquer Voldemort");
                System.out.println("2. Attaquer Bellatrix Lestrange");
                System.out.println("3. Utiliser une potion de soin");

                int choice = Integer.parseInt(inputSource.getInput());

                if (choice == 1) {
                    wizard.attack(voldemort);
                    System.out.println("Vous attaquez Voldemort !");
                } else if (choice == 2) {
                    wizard.attack(bellatrix);
                    System.out.println("Vous attaquez Bellatrix Lestrange !");
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
                if (bellatrix.getHealthPoints() > 0) {
                    bellatrix.attack(wizard);
                    System.out.println("Bellatrix Lestrange vous attaque !");
                }
            }

            playerTurn = !playerTurn;
        }

        if (wizard.getHealthPoints() > 0) {
            System.out.println("Félicitations ! Vous avez vaincu Voldemort et Bellatrix Lestrange !");
            wizard.addToInventory(new MajorHealingPotion());
            System.out.println("Vous avez obtenu une potion de soin majeure !");
            return true;
        } else {
            System.out.println("Vous avez été vaincu par Voldemort et Bellatrix Lestrange.");
            return false;
        }
    }
}