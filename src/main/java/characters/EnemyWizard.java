package characters;

import houses.House;

public class EnemyWizard extends Wizard {

    public EnemyWizard(String name, int healthPoints, int damage, int healingPower, House house) {
        super(name, healthPoints, damage, house);
    }
}