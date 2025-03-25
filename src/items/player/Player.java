package items.player;

import items.Inventory;
import items.Item;
import items.OffHand;
import items.Weapon;

public class Player {

    private int maxHealth;
    private int health;
    private int defence;
    private int damage;
    private Inventory inventory;
    private Weapon weapon;
    private OffHand offHand;

    public Player() {
        maxHealth = 100;
        health = 10;
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
        setMaxHealth();
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    private void setMaxHealth() {
        if (offHand != null) {
            this.maxHealth = 100 + offHand.getHealthBuff();
            if (maxHealth == health + offHand.getHealthBuff()) {
                setHealth(maxHealth);
            } else if (health > maxHealth) {
                setHealth(maxHealth);
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefence() {
        if (offHand != null) {
            return defence + offHand.getDefenceBuff();
        }
        return  damage;
    }

    public void setDefence(int defence) {
        this.defence += defence;
    }

    public int getDamage() {
        int d = damage;
        if (weapon != null) {
            d += weapon.getDamage();
            if (hasItem("Quiver") && weapon.getName().equalsIgnoreCase("Crossbow")) {
                d += 5;
            } else if (hasItem("Grindstone") && weapon.getName().equalsIgnoreCase("Broadsword")) {
                d += 5;
            } else if (hasItem("Talisman") && weapon.getName().equalsIgnoreCase("Fire-Staff")) {
                d += 5;
            }
        }
        if (offHand != null) {
            d += offHand.getDamageBuff();
        }
        return d;
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
                if (inventory.getItems()[i] != null) {
                    if (inventory.getItems()[i].getName().equalsIgnoreCase(name)) {
                        item = inventory.getItems()[i];
                        return item;
                    }
                }
            }
        }
        return null;
    }

    public boolean hasItem(String name){
        if (inventory.getItems() != null) {
            for (int i = 0; i < inventory.getItems().length; i++) {
                if (inventory.getItems()[i] != null) {
                    if (inventory.getItems()[i].getName().equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Item removeItem(String name) {
        Item item;
        if (inventory.getItems() != null) {
            for (int i = 0; i < inventory.getItems().length; i++) {
                if (inventory.getItems()[i] != null) {
                    if (inventory.getItems()[i].getName().equalsIgnoreCase(name)) {
                        item = inventory.getItems()[i];
                        inventory.getItems()[i] = null;
                        return item;
                    }
                }
            }
        }
        return null;
    }

    public void changeAmount(String name, int amount){
        if (inventory.getItems() != null) {
            for (int i = 0; i < inventory.getItems().length; i++) {
                if (inventory.getItems()[i] != null) {
                    if (inventory.getItems()[i].getName().equalsIgnoreCase(name)) {
                        inventory.getItems()[i].changeAmount(amount);
                        if (inventory.getItems()[i].getAmount() <= 0) {
                            removeItem(name);
                        }
                    }
                }
            }
        }
    }

    public String inventoryDescription(){
        String line = "Hour health is " + getHealth() + "/" + getMaxHealth()  + ".";
        if (getWeapon() != null) {
            line += "\n" + weapon.description();
        }
        if (getOffHand() != null) {
            line += "\n" + offHand.description();
        }
        line += "\n" + inventory.description();
        return line;
    }
}
