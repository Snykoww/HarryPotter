package items;

public class HealingItem {

    private String name;
    private int healingPoints;

    public HealingItem(String name, int healingPoints) {
        this.name = name;
        this.healingPoints = healingPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealingPoints() {
        return healingPoints;
    }

    public void setHealingPoints(int healingPoints) {
        this.healingPoints = healingPoints;
    }

}