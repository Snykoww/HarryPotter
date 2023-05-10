package creatures;

import characters.Character;

public class DeathEater extends Character {

    public DeathEater(String name, int healthPoints, int damage) {
        super(name, healthPoints);
        setDamage(damage);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        setHealthPoints(getHealthPoints() - damage);
    }
}