package levels;

import characters.Wizard;
import creatures.Troll;
import input.InputSource;

public class Level1 extends Level {

    public Level1() {
        super("Level 1");
    }

    @Override
    public boolean startLevel(Wizard player, InputSource inputSource) {
        System.out.println("Niveau 1: Le troll bloque votre chemin!");
        Troll troll = new Troll("Troll", 100, 15);

        while (troll.getHealthPoints() > 0 && player.getHealthPoints() > 0) {
            System.out.println("Le joueur attaque le troll!");
            player.attack(troll);
            System.out.println("Troll - Points de vie restants: " + troll.getHealthPoints());

            if (troll.getHealthPoints() > 0) {
                System.out.println("Le troll attaque le joueur!");
                troll.attack(player);
                System.out.println("Joueur - Points de vie restants: " + player.getHealthPoints());
            }
        }

        if (player.getHealthPoints() > 0) {
            System.out.println("Félicitations! Vous avez vaincu le troll et passé le niveau 1.");
        } else {
            System.out.println("Dommage! Vous avez été vaincu par le troll.");
        }


        return true;
    }
}