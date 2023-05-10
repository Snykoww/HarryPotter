package levels;

import characters.Wizard;
import creatures.DoloresUmbridge;
import items.MajorHealingPotion;
import input.InputSource;

public class Level5 extends Level {

    public Level5() {
        super("Niveau 5");
    }

    @Override
    public boolean startLevel(Wizard wizard, InputSource inputSource) {
        System.out.println("Bienvenue dans le niveau 5 !");
        System.out.println("Vous allez maintenant affronter Dolores Umbridge.");

        DoloresUmbridge umbridge = new DoloresUmbridge("Dolores Umbridge", 150, 30);

        while (wizard.getHealthPoints() > 0 && umbridge.getHealthPoints() > 0) {
            System.out.println("\nPoints de vie du sorcier : " + wizard.getHealthPoints());
            System.out.println("Points de vie de Dolores Umbridge : " + umbridge.getHealthPoints());

            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Utiliser une potion de soin");
            String input = inputSource.getInput();
            int choice = Integer.parseInt(input);

            if (choice == 1) {
                wizard.attack(umbridge);
                System.out.println("Vous attaquez Dolores Umbridge !");
            } else if (choice == 2) {
                System.out.println("Veuillez entrer l'index de la potion de soin à utiliser:");
                input = inputSource.getInput();
                int itemIndex = Integer.parseInt(input) - 1;
                wizard.useHealingItem(itemIndex);
                System.out.println("Vous utilisez une potion de soin !");
            } else {
                System.out.println("Choix invalide. Vous ne faites rien.");
            }

            if (umbridge.getHealthPoints() > 0) {
                umbridge.attack(wizard);
                System.out.println("Dolores Umbridge vous attaque !");
            }
        }

        if (wizard.getHealthPoints() > 0) {
            System.out.println("Félicitations ! Vous avez vaincu Dolores Umbridge et terminé le niveau 5.");
            MajorHealingPotion majorHealingPotion = new MajorHealingPotion();
            wizard.addToInventory(majorHealingPotion);
            System.out.println("Vous avez gagné une potion de soin majeure !");
            return true;
        } else {
            System.out.println("Vous avez été vaincu par Dolores Umbridge.");
            return false;
        }
    }
}