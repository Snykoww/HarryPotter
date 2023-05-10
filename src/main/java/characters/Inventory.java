package characters;

import items.HealingItem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<HealingItem> healingItems;

    public Inventory() {
        this.healingItems = new ArrayList<>();
    }

    // Ajoute un objet de soin à l'inventaire
    public void addHealingItem(HealingItem item) {
        healingItems.add(item);
    }

    // Supprime un objet de soin de l'inventaire
    public HealingItem removeHealingItem(int index) {
        return healingItems.remove(index);
    }

    // Récupère un objet de soin de l'inventaire
    public HealingItem getHealingItem(int index) {
        return healingItems.get(index);
    }

    // Récupère le nombre d'objets de soin dans l'inventaire
    public int getHealingItemCount() {
        return healingItems.size();
    }}
