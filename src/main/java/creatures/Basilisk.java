package creatures;

public class Basilisk extends Creature {
    public Basilisk(String name, int healthPoints, int damage) {
        super(name, healthPoints, damage);
    }

    // Pas besoin de réimplémenter la méthode attack() ici, car elle est déjà définie dans la classe Creature.
}