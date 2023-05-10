package levels;

import characters.Wizard;
import creatures.Basilisk;
import input.InputSource;

public class Level2 extends Level {

    public Level2() {
        super("Level 2");
    }

    @Override
    public boolean startLevel(Wizard wizard, InputSource inputSource) {
        System.out.println("Bienvenue au niveau 2, vous devez combattre un Basilic !");
        Basilisk basilisk = new Basilisk("Basilisk", 100, 20);

        while (wizard.getHealthPoints() > 0 && basilisk.getHealthPoints() > 0) {
            System.out.println("1. Attaquer le Basilic");
            System.out.println("2. Se soigner");
            int action = Integer.parseInt(inputSource.getInput());

            switch (action) {
                case 1:
                    wizard.attack(basilisk);
                    System.out.println("Vous attaquez le Basilic !");
                    if (basilisk.getHealthPoints() <= 0) {
                        System.out.println("Félicitations ! Vous avez vaincu le Basilic.");
                        return true;
                    }
                    break;
                case 2:
                    System.out.println("Choisissez l'objet de soin à utiliser :");
                    wizard.displayInventory();
                    int itemIndex = Integer.parseInt(inputSource.getInput()) - 1;
                    int healingAmount = wizard.useHealingItem(itemIndex);
                    wizard.heal(healingAmount);
                    System.out.println("Vous utilisez un objet de soin pour récupérer " + healingAmount + " points de vie.");
                    break;
                default:
                    System.out.println("Choix invalide. Vous ne faites rien.");
                    break;
            }

            basilisk.attack(wizard);
            System.out.println("Le Basilic vous attaque !Vos points de vie restants: "+ wizard.getHealthPoints());
            if (wizard.getHealthPoints() <= 0) {
                System.out.println("Le Basilic vous a vaincu.");
                return false;
            }
        }
        return false;
    }
}