package items.player;

import items.Inventory;
import items.Item;
import items.OffHand;
import items.Weapon;

public class Player {

    private int health;
    private int defence;
    private int damage;
    private Inventory inventory;
    private Weapon weapon;
    private OffHand offHand;

    public Player() {
        health = 100;
        defence = 0;
        damage = 5;
        inventory = new Inventory();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public OffHand getOffHand() {
        return offHand;
    }

    public void setOffHand(OffHand offHand) {
        this.offHand = offHand;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence += defence;
    }

    public int getDamage() {
        if (weapon != null) {
            return damage + weapon.getDamage();
        }
        return  damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean addItem(Item item) {
        if (inventory.addItem(item)) {
            return true;
        } else {
            return false;
        }
    }

    public Item findItem(String name) {
        Item item;
        if (inventory.getItems() != null) {
            for (int i = 0; i < inventory.getItems().length; i++) {
                if (inventory.getItems()[i].getName().equalsIgnoreCase(name)) {
                    item = inventory.getItems()[i];
                    inventory.getItems()[i] = null;
                    return item;
                }
            }
        }
        return null;
    }
}
