package spells;

import characters.Character;
import characters.Wizard;

public abstract class Spell {
    private String name;
    private int power;

    public Spell(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public abstract void cast(Wizard caster, Character target);
}