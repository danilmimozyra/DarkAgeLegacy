package NPCs;

import items.Item;

public class Enemy extends NPC{

    private int damage;
    private Item[] drops;

    public Enemy(String name, int health, int damage) {
        super(name, health);

        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Item[] getDrops() {
        return drops;
    }

    public void setDrops(Item[] drops) {
        this.drops = drops;
    }
}
