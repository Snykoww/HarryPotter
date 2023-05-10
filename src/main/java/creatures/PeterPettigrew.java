package creatures;

import characters.Character;

public class PeterPettigrew extends Character {

    public PeterPettigrew(String name, int healthPoints, int damage) {
        super(name, healthPoints);
        setDamage(damage);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(getDamage());
    }
}
