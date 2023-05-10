package creatures;

import characters.Character;

public abstract class Creature extends Character {
    private int damage;

    public Creature(String name, int healthPoints, int damage) {
        super(name, healthPoints);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void attack(Character target) {
        target.setHealthPoints(target.getHealthPoints() - this.damage);
    }
}