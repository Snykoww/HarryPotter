package levels;

import characters.Wizard;
import creatures.Dementor;
import input.InputSource;

public class Level3 extends Level {

    public Level3() {
        super("Niveau 3");
    }

    @Override
    public boolean startLevel(Wizard wizard, InputSource inputSource) {
        System.out.println("Bienvenue dans le niveau 3 !");
        System.out.println("Vous allez maintenant affronter un Détraqueur.");

        Dementor dementor = new Dementor("Dementor", 100, 25);
        boolean playerTurn = true;

        while (wizard.getHealthPoints() > 0 && dementor.getHealthPoints() > 0) {
            System.out.println("\nPoints de vie du sorcier : " + wizard.getHealthPoints());
            System.out.println("Points de vie du Dementor : " + dementor.getHealthPoints());

            if (playerTurn) {
                System.out.println("\nC'est votre tour. Que voulez-vous faire ?");
                System.out.println("1. Attaquer");
                System.out.println("2. Se soigner");
                System.out.println("3. Lancer un Patronus");

                String input = inputSource.getInput();
                int choice = Integer.parseInt(input);

                if (choice == 1) {
                    wizard.attack(dementor);
                    System.out.println("Vous attaquez le Dementor !");
                } else if (choice == 2) {
                    wizard.displayInventory();
                    System.out.println("Vous vous soignez !");
                } else if (choice == 3) {
                    wizard.castPatronus(dementor);
                    System.out.println("Vous lancez un Patronus sur le Dementor !");
                } else {
                    System.out.println("Choix invalide. Vous ne faites rien.");
                }
            } else {
                dementor.attack(wizard);
                System.out.println("Le Dementor vous attaque !");
            }

            playerTurn = !playerTurn;
        }

        if (wizard.getHealthPoints() > 0) {
            System.out.println("Félicitations ! Vous avez vaincu le Dementor !");
            return true;
        } else {
            System.out.println("Vous avez été vaincu par le Dementor.");
            return false;
        }
    }
}