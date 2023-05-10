package creatures;

public class Dragon extends Creature {
    public Dragon(String name, int healthPoints, int damage) {
        super(name, healthPoints, damage);
    }


    public void attack(Creature target) {
        target.setHealthPoints(target.getHealthPoints() - getDamage());
    }
}