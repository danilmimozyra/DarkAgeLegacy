package NPCs;

public class Enemy extends NPC {

    private final int damage;
    private int defence;

    public Enemy(String name, int health, int damage, int defence) {
        super(name, health);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }
}