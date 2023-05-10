package characters;

import houses.House;
import items.HealingItem;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {

    private int healingPower;
    private List<HealingItem> inventory;
    private int maxHealthPoints;
    private House house;

    public Wizard(String name, int healthPoints, int damage, House house) {
        super(name, healthPoints);
        setDamage(damage);
        this.healingPower = healingPower;
        this.inventory = new ArrayList<>();
        this.maxHealthPoints = healthPoints;
        this.house = house;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public House getHouse() {
        return house;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public void addToInventory(HealingItem item) {
        inventory.add(item);
    }

    public void castPatronus(Character target) {
        int patronusDamage = 50;
        target.takeDamage(patronusDamage);
        System.out.println(getName() + " casts a Patronus on " + target.getName() + " for " + patronusDamage + " damage!");
    }

    public void castSpell(Character target) {
        int spellDamage = 25;
        target.takeDamage(spellDamage);
        System.out.println(getName() + " casts a spell on " + target.getName() + " for " + spellDamage + " damage!");
    }

    public int useHealingItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            HealingItem item = inventory.get(index);
            heal(item.getHealingPoints());
            inventory.remove(index);
        }
        return index;
    }

    public void heal(int healingPoints) {
        setHealthPoints(Math.min(getHealthPoints() + healingPoints, getMaxHealthPoints()));
    }

    public void attack(Character target) {
        target.takeDamage(getDamage());
    }

    public void takeDamage(int damage) {
        setHealthPoints(getHealthPoints() - damage);
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public void displayInventory() {
        System.out.println("Inventaire:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i).getName());
        }
    }
}