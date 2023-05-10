package levels;

import characters.Wizard;
import creatures.DeathEater;
import items.HealingItem;
import input.InputSource;

public class Level6 extends Level {

    public Level6() {
        super("Niveau 6");
    }

    @Override
    public boolean startLevel(Wizard wizard, InputSource inputSource) {
        System.out.println("Bienvenue dans le niveau 6 !");
        System.out.println("Vous allez maintenant affronter des Mangemorts.");

        DeathEater deathEater = new DeathEater("Mangemort", 130, 30);
        boolean allDeathEatersDefeated = false;
        int deathEatersDefeated = 0;

        while (wizard.getHealthPoints() > 0 && !allDeathEatersDefeated) {
            battle(wizard, deathEater, inputSource);
            if (deathEater.getHealthPoints() <= 0) {
                deathEatersDefeated++;
                deathEater.setHealthPoints(130);
            }

            if (deathEatersDefeated >= 3) {
                allDeathEatersDefeated = true;
                System.out.println("Félicitations ! Vous avez éliminé tous les Mangemorts et terminé le niveau 6.");
            }
        }

        if (allDeathEatersDefeated) {
            wizard.addToInventory(new HealingItem("Potion de vie majeure", 50));
            return true;
        } else {
            System.out.println("Les Mangemorts vous ont vaincu. Essayez à nouveau !");
            return false;
        }
    }

    private void battle(Wizard wizard, DeathEater enemy, InputSource inputSource) {
        System.out.println("\nPoints de vie du sorcier : " + wizard.getHealthPoints());
        System.out.println("Points de vie de " + enemy.getName() + " : " + enemy.getHealthPoints());

        System.out.println("\nC'est votre tour. Que voulez-vous faire ?");
        System.out.println("1. Attaquer");
        System.out.println("2. Lancer un sort");
        System.out.println("3. Utiliser une potion de soin");

        String input = inputSource.getInput();
        int choice = Integer.parseInt(input);

        if (choice == 1) {
            wizard.attack(enemy);
            System.out.println("Vous attaquez " + enemy.getName() + " !");
        } else if (choice == 2) {
            wizard.castSpell(enemy);
            System.out.println("Vous lancez un sort sur " + enemy.getName() + " !");
        } else if (choice == 3) {
            wizard.displayInventory();
            System.out.println("Entrez l'index de la potion de soin que vous voulez utiliser:");
            input = inputSource.getInput();
            int itemIndex = Integer.parseInt(input) - 1;
            wizard.useHealingItem(itemIndex);
        } else {
            System.out.println("Choix invalide. Vous ne faites rien.");
        }

        if (enemy.getHealthPoints() > 0) {
            enemy.attack(wizard);
            System.out.println(enemy.getName() + " vous attaque !");
        }
    }
}